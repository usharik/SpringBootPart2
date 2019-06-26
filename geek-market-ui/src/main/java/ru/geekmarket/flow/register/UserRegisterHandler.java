package ru.geekmarket.flow.register;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;

public class UserRegisterHandler {

    private static final String FAILURE = "failure";
    private static final String SUCCESS = "success";

    public UserRegisterModel init() {
        return new UserRegisterModel();
    }

    public void addBasicUserInfo(UserRegisterModel userRegisterModel, BasicUserInfo basicUserInfo) {
        userRegisterModel.setBasicUserInfo(basicUserInfo);
    }

    public void addPersonalUserInfo(UserRegisterModel userRegisterModel, PersonalUserInfo personalUserInfo) {
        userRegisterModel.setPersonalUserInfo(personalUserInfo);
    }

    public String validateBasicUserInfo(BasicUserInfo basicUserInfo, MessageContext error) {
        if (!basicUserInfo.getPassword().equals(basicUserInfo.getConfirmPassword())) {
            error.addMessage(new MessageBuilder()
                    .error()
                    .source("confirmPassword") //
                    .defaultText("Password doesn't match up the confirm password!") //
                    .build());

            return FAILURE;
        }
        return SUCCESS;
    }

    public String validatePersonalUserInfo(PersonalUserInfo personalUserInfo, MessageContext error) {
        return SUCCESS;
    }

    public String saveAll(UserRegisterModel userRegisterModel, MessageContext error) {
        return SUCCESS;
    }
}
