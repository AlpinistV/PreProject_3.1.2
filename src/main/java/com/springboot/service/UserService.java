package com.springboot.service;

import com.springboot.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.sql.SQLException;
import java.util.List;

public interface UserService extends UserDetailsService {
    void addUser(User user) throws SQLException;
    List<User> getAllUser() throws SQLException;
    void updateUser(User user) throws SQLException;
    User getUserById(long id) throws SQLException;
    void deleteUser(User user) throws SQLException;

}
