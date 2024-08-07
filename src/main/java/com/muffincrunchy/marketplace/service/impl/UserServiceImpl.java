package com.muffincrunchy.marketplace.service.impl;

import com.muffincrunchy.marketplace.model.dto.request.UserRequest;
import com.muffincrunchy.marketplace.model.entity.User;
import com.muffincrunchy.marketplace.repository.UserRepository;
import com.muffincrunchy.marketplace.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User create(UserRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .birthDate(Date.valueOf(request.getBirthDate()))
                .phoneNo(request.getPhoneNo())
                .build();
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User update(User request) {
        getById(request.getId());
        return userRepository.saveAndFlush(request);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
