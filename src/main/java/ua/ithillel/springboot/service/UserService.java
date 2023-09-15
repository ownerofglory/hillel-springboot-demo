package ua.ithillel.springboot.service;

import ua.ithillel.springboot.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserById(Long id);
    User findUserByEmail(String email);
    List<User> findAllUsers(int num, int count);
    List<User> findAllUsersSorted(boolean nameAsc);
}
