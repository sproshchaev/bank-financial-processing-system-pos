package ru.sbp.bankfinancialprocessingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class PosCustomUserDetailedService implements UserDetailsService {

    private PosUserCache userCache;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PosUserInfo info = userCache.get(username);
        if (info == null) {
            throw new UsernameNotFoundException("User id=" + username + " not found!");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + info.getRole()));

        return new User(info.getLogin(), info.getPassword(), authorities);
    }

    @Autowired
    public void setUserCache(PosUserCache userCache) {
        this.userCache = userCache;
    }
}
