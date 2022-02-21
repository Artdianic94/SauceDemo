package models;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class LoginModel {
    private String emailFirst;
    private String emailSecond;
    private String emailThird;
    private String emailFourth;
    private String password;
}
