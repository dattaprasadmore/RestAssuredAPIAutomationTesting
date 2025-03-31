package com.api.models.requests.users;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProfileRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
}