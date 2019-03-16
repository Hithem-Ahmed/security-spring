package com.example.demo.service;

import com.example.demo.model.RoleDO;
import com.example.demo.model.UserDO;
import com.example.demo.model.UserPrincipal;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class InternalUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public InternalUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown User");
        }
        final boolean enabled = true;
        final boolean accountNonExpired = true;
        final boolean credentialsNotExpired = true;
        final boolean accountNonLocked = true;
        UserPrincipal principal = new UserPrincipal(
                user,
                enabled, accountNonExpired, credentialsNotExpired, accountNonLocked,
                getAuthorities(user.getRoles())
        );
        return principal;
    }

    private List<GrantedAuthority> getAuthorities(Set<RoleDO> roles) {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority(r.getAuthority()))
                .collect(Collectors.toList());
    }
}
