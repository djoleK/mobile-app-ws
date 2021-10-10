package com.djole.mobileappws.services.impl;

import com.djole.mobileappws.services.UserService;
import com.djole.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.djole.mobileappws.ui.model.response.UserRest;
import com.djole.mobileappws.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;

    private final Utils utils;

    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetailsRequestModel) {
        UserRest userRest = new UserRest();
        userRest.setEmail(userDetailsRequestModel.getEmail());
        userRest.setFirstName(userDetailsRequestModel.getFirstName());
        userRest.setLastName(userDetailsRequestModel.getLastName());

        String userId = utils.generateUserId();
        userRest.setUserId(userId);
        if (users == null) {
            users = new HashMap<>();
            users.put(userId, userRest);
        }
        return userRest;
    }
}
