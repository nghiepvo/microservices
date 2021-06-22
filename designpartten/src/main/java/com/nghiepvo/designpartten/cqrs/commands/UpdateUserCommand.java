package com.nghiepvo.designpartten.cqrs.commands;

import com.nghiepvo.designpartten.domain.Address;
import com.nghiepvo.designpartten.domain.Contact;
import lombok.Data;
import lombok.NonNull;

import java.util.Set;

@Data
public class UpdateUserCommand {

    @NonNull
    private String userId;

    @NonNull
    private Set<Address> addresses;

    @NonNull
    private Set<Contact> contacts;
}
