package com.nghiepvo.userservice.models;

import com.nghiepvo.userservice.models.RegisterUserDto;
import com.nghiepvo.userservice.models.User;
import org.modelmapper.PropertyMap;

public class UserMapping extends PropertyMap<RegisterUserDto, User> {

    @Override
    protected void configure() {

    }
}
