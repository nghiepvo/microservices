package com.nghiepvo.designpartten.cqrs.aggregates;

import com.nghiepvo.designpartten.cqrs.commands.CreateUserCommand;
import com.nghiepvo.designpartten.cqrs.commands.UpdateUserCommand;
import com.nghiepvo.designpartten.cqrs.repositories.UserWriteRepository;
import com.nghiepvo.designpartten.domain.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserAggregate {

    @NonNull
    private UserWriteRepository writeRepository;

    public User handleCreateUserCommand(CreateUserCommand command) {

        var user = new User(command.getUserId(), command.getFirstName(), command.getLastName());

        writeRepository.addUser(command.getUserId(), user);

        return user;
    }

    public User handleUpdateUserCommand(UpdateUserCommand command) throws Exception {

        var user = writeRepository.getUser(command.getUserId());

        if (user == null) {
            throw new Exception("The User doesn't available.");
        }
        user.setAddresses(command.getAddresses());

        user.setContacts(command.getContacts());

        return user;
    }
}
