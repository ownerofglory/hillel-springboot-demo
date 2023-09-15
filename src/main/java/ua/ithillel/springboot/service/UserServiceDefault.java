package ua.ithillel.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.ithillel.springboot.model.User;
import ua.ithillel.springboot.repo.UserRepo;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceDefault implements UserService {
    private final UserRepo userRepo;

    public UserServiceDefault(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User saveUser(User user) {
        User savedUser = userRepo.save(user);
        return savedUser;
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> byId = userRepo.findById(id);
        return byId.orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> byEmail = userRepo.findByEmail(email);
        return byEmail.orElse(null);
    }

    @Override
    public List<User> findAllUsers(int num, int count) {
        PageRequest criteria = PageRequest.of(num, count);
        Page<User> userPage = userRepo.findAll(criteria);
        return userPage.get().toList();
    }

    @Override
    public List<User> findAllUsersSorted(boolean nameAsc) {
//        Sort sortCriteria = Sort.by("name");
        Sort.Direction direction = nameAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortCriteria = Sort.by(direction, "name");
        List<User> all = userRepo.findAll(sortCriteria);
        return all;
    }
}
