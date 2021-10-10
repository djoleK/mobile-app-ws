package com.djole.mobileappws.ui.controller;

import com.djole.mobileappws.exceptions.UserServiceException;
import com.djole.mobileappws.services.UserService;
import com.djole.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.djole.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.djole.mobileappws.ui.model.response.UserRest;
import com.djole.mobileappws.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, UserRest> users;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get users was called with page number:" + page + " and limit number: " + limit + " and sort: " + sort;
    }

    @GetMapping(path = "{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

        throw new UserServiceException("A user service exception is thrown");


    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest userRest = userService.createUser(userDetails);
        return new ResponseEntity<>(userRest, HttpStatus.CREATED);
    }

    @PutMapping(path = "{userId}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails);
        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
