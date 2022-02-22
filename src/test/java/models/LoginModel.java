package models;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class LoginModel {
    private String email;
    private String password;
}
