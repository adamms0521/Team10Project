package edu.uiowa.projectteam10.security;

import java.util.Arrays;

import edu.uiowa.projectteam10.model.User;
import edu.uiowa.projectteam10.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User activeUserInfo = userService.getCurrentUser();
        String authority = activeUserInfo.getRole();
        UserDetails userDetails = (UserDetails)new User(activeUserInfo.getUserName(),
                activeUserInfo.getPassword(), authority);
        return userDetails;
    }
}