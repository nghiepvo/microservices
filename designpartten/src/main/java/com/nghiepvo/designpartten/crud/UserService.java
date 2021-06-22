package com.nghiepvo.designpartten.crud;

import com.nghiepvo.designpartten.domain.Address;
import com.nghiepvo.designpartten.domain.Contact;
import com.nghiepvo.designpartten.domain.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserService {

    @NonNull
    private UserRepository userRepository;


    public void createUser(String id, String firstName, String lastName) {

        var user = new User(id, firstName, lastName);

        userRepository.addUser(id, user);

    }

    public void updateUser(String id, Set<Contact> contact, Set<Address> address) throws Exception {
        var user = userRepository.getUser(id);

        if (user == null) {
            throw new Exception("The User doesn't available.");
        }

        user.setContacts(contact);

        user.setAddresses(address);

        userRepository.addUser(id, user);
    }

    public Set<Contact> getContactByType(String id, String type) throws Exception {

        var user = userRepository.getUser(id);

        if (user == null) {
            throw new Exception("The User doesn't available.");
        }

        var contacts = user.getContacts();

        return contacts
                .stream()
                .filter(f -> f.getType().equals(type))
                .collect(Collectors.toSet());

    }

    public Set<Address> getAddressByRegion(String id, String state) throws Exception {

        var user = userRepository.getUser(id);

        if (user == null) {
            throw new Exception("The User doesn't available.");
        }

        var addresses = user.getAddresses();

        return addresses
                .stream()
                .filter(f -> f.getState().equals(state))
                .collect(Collectors.toSet());

    }
}
