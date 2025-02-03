package com.win.userservice.service;

import com.win.userservice.entity.User;
import com.win.userservice.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public UserDTO createUser(UserDTO user);

//    @PostAuthorize("(returnObject.username == authentication.name) || hasRole('ROLE_ADMIN')")
    public boolean deleteUser(Long id);

//    @PostAuthorize("(returnObject.username == authentication.name) || hasRole('ROLE_ADMIN')")
    public UserDTO getUser(Long id);

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserDTO> getUsers();

//    @PostAuthorize("returnObject.username == authentication.name")
    public UserDTO updateUser(Long id,UserDTO user);

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Long> getUserRegistrationCountByMonthAndDay(int year, int month);

    public List<UserDTO> create100Users();

    public String getFullName(String username);

    public User getUserByUserName(String username);

    public User updatePassword(String username, String password);

    public String getEmailByUsername(String username);
}
