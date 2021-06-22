package com.nghiepvo.designpartten.cqrs.projections;

import java.util.Set;

import com.nghiepvo.designpartten.cqrs.queries.AddressByRegionQuery;
import com.nghiepvo.designpartten.cqrs.queries.ContactByTypeQuery;
import com.nghiepvo.designpartten.cqrs.repositories.UserReadRepository;
import com.nghiepvo.designpartten.domain.Address;
import com.nghiepvo.designpartten.domain.Contact;
import com.nghiepvo.designpartten.domain.UserAddress;
import com.nghiepvo.designpartten.domain.UserContact;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserProjection {
    @NonNull
    private UserReadRepository repository;

    public Set<Contact> handle(ContactByTypeQuery query) throws Exception {

        UserContact userContact = repository.getUserContact(query.getUserId());

        if (userContact == null) {
            throw new Exception("The User doesn't available.");
        }

        return userContact.getContactByType()
                .get(query.getContactType());
    }

    public Set<Address> handle(AddressByRegionQuery query) throws Exception {

        UserAddress userAddress = repository.getUserAddress(query.getUserId());

        if (userAddress == null) {
            throw new Exception("The User doesn't available.");
        }

        return userAddress.getAddressByRegion()
                .get(query.getState());
    }

}