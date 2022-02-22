package testdata;

import models.LoginModel;
import staticdata.WebUrl;

public class GetLoginModel {
    public static LoginModel loginWithFirstEmailModel() {
        String password = WebUrl.PASSWORD;
        LoginModel loginModel = LoginModel
                .builder()
                .email(WebUrl.EMAIL_FIRST)
                .password(password)
                .build();
        return loginModel;
    }

    public static LoginModel loginWithSecondEmailModel() {
        String password = WebUrl.PASSWORD;
        LoginModel loginModel = LoginModel
                .builder()
                .email(WebUrl.EMAIL_FIRST)
                .password(password)
                .build();
        return loginModel;
    }

    public static LoginModel loginWithThirdEmailModel() {
        String password = WebUrl.PASSWORD;
        LoginModel loginModel = LoginModel
                .builder()
                .email(WebUrl.EMAIL_THIRD)
                .password(password)
                .build();
        return loginModel;
    }

    public static LoginModel loginWithFourthEmailModel() {
        String password = WebUrl.PASSWORD;
        LoginModel loginModel = LoginModel
                .builder()
                .email(WebUrl.EMAIL_FOURTH)
                .password(password)
                .build();
        return loginModel;
    }

}
