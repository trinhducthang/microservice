package com.win.userservice.service;


import com.win.userservice.entity.User;
import com.win.userservice.dto.UserDTO;
import com.win.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;



    @Override
    public UserDTO createUser(UserDTO user) {

        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        return false;
    }

    @Override
    public UserDTO getUser(Long id) {
        return null;
    }

    @Override
    public List<UserDTO> getUsers() {
        return List.of();
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO user) {
        return null;
    }

    @Override
    public List<Long> getUserRegistrationCountByMonthAndDay(int year, int month) {
        return List.of();
    }

    @Override
    public List<UserDTO> create100Users() {
        return List.of();
    }

    @Override
    public String getFullName(String username) {
        return "";
    }

    @Override
    public User getUserByUserName(String username) {
        return null;
    }

    @Override
    public User updatePassword(String username, String password) {
        return null;
    }

    @Override
    public String getEmailByUsername(String username) {
        return "";
    }
}
