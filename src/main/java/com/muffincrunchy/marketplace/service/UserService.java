package com.muffincrunchy.marketplace.service;

import com.muffincrunchy.marketplace.model.dto.request.UserRequest;
import com.muffincrunchy.marketplace.model.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getById(String  id);
    User create(UserRequest request);
    User update(User request);
    void delete(String id);
}
