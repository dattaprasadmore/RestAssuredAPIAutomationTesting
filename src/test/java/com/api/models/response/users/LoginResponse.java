package com.api.models.response.users;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LoginResponse {
    private String token;
    private String type;
    private int id;
    private String username;
    private String email;
    private List<String> roles;
}
