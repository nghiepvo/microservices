package com.nghiepvo.designpartten.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Address {
    @NonNull
    private String city;
    @NonNull
    private String state;
    @NonNull
    private String postcode;
}
