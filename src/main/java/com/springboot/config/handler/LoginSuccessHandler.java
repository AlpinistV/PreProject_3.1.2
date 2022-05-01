package com.springboot.config.handler;

import com.springboot.entity.Role;
import com.springboot.entity.User;
import com.springboot.service.RoleService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final RoleService roleService;


    public LoginSuccessHandler(RoleService roleService ) {
        this.roleService = roleService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        Set<Role> set = user.getRoles();
        httpServletRequest.getSession().setAttribute("userInfo", user);
        Role role = roleService.getRoleByName("ADMIN");
        if (set.contains(role)){
            httpServletResponse.sendRedirect("/admin/select");
        } else if(user.getRoles().contains(roleService.getRoleByName("USER")) && !user.getRoles().contains(roleService.getRoleByName("ADMIN"))){
            httpServletResponse.sendRedirect("/user");
        }
    }
}