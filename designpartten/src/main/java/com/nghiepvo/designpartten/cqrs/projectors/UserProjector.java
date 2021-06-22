package com.nghiepvo.designpartten.cqrs.projectors;

import com.nghiepvo.designpartten.cqrs.repositories.UserReadRepository;
import com.nghiepvo.designpartten.domain.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;


@RequiredArgsConstructor
public class UserProjector {

    @NonNull
    private UserReadRepository readRepository;

    public void project(User user) {

        var userContact = Optional
                .ofNullable(readRepository.getUserContact(user.getId()))
                .orElse(new UserContact());

        Map<String, Set<Contact>> contactTypeMap = new HashMap<>();

        for (var contact : user.getContacts()) {

            var contacts = Optional
                    .ofNullable(contactTypeMap.get(contact.getType()))
                    .orElse(new HashSet<>());

            contacts.add(contact);

            contactTypeMap.put(contact.getType(), contacts);

        }

        userContact.setContactByType(contactTypeMap);

        readRepository.addUserContact(user.getId(), userContact);

        var userAddress = Optional
                .ofNullable(readRepository.getUserAddress(user.getId()))
                .orElse(new UserAddress());

        Map<String, Set<Address>> addressByRegion = new HashMap<>();

        for (var address : user.getAddresses()) {

            var addresses = Optional
                    .ofNullable(addressByRegion.get(address.getState()))
                    .orElse(new HashSet<>());

            addresses.add(address);

            addressByRegion.put(address.getState(), addresses);
        }

        userAddress.setAddressByRegion(addressByRegion);

        readRepository.addUserAddress(user.getId(), userAddress);
    }
}
