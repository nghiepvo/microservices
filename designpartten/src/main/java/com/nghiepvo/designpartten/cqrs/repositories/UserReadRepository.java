package com.nghiepvo.designpartten.cqrs.repositories;

import com.nghiepvo.designpartten.domain.UserAddress;
import com.nghiepvo.designpartten.domain.UserContact;

import java.util.HashMap;
import java.util.Map;

public class UserReadRepository {

    private Map<String, UserAddress> userAddressMap = new HashMap<>();

    private Map<String, UserContact> userContactMap = new HashMap<>();

    public void addUserAddress(String id, UserAddress userAddress) {
        userAddressMap.put(id, userAddress);
    }

    public UserAddress getUserAddress(String id) {
        return userAddressMap.get(id);
    }

    public void addUserContact(String id, UserContact userContact) {
        userContactMap.put(id, userContact);
    }

    public UserContact getUserContact(String id) {
        return userContactMap.get(id);
    }
}
