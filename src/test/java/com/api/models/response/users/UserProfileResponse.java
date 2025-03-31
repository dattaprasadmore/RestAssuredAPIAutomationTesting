package com.api.models.response.users;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserProfileResponse {
    private int id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;
}
