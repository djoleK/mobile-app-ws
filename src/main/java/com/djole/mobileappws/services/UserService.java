package com.djole.mobileappws.services;

import com.djole.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.djole.mobileappws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel model);
}
