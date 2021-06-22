package com.nghiepvo.designpartten.cqrs.commands;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateUserCommand {
    @NonNull
    private String userId;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
}
