package com.nghiepvo.designpartten.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Contact {
    @NonNull
    private String type;
    @NonNull
    private String detail;
}
