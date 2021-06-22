package com.nghiepvo.designpartten.cqrs.queries;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactByTypeQuery {
    @NonNull
    private  String userId;
    @NonNull
    private  String contactType;
}
