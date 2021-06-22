package com.nghiepvo.designpartten.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class User {

    @NonNull
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private Set<Contact> contacts = new HashSet<>();
    private Set<Address> addresses = new HashSet<>();
}
