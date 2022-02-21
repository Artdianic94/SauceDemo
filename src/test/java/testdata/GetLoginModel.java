package testdata;

import models.LoginModel;
import staticdata.WebUrl;

public class GetLoginModel {
    public static LoginModel loginModel() {
        String password = WebUrl.PASSWORD;
        LoginModel loginModel = LoginModel
                .builder()
                .emailFirst(WebUrl.EMAIL_FIRST)
                .emailSecond(WebUrl.EMAIL_SECOND)
                .emailThird(WebUrl.EMAIL_THIRD)
                .emailFourth(WebUrl.EMAIL_FOURTH)
                .password(password)
                .build();
        return loginModel;
    }
}
