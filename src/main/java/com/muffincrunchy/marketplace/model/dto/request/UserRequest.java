package com.muffincrunchy.marketplace.model.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserRequest {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String email;
    private String phoneNo;
}
