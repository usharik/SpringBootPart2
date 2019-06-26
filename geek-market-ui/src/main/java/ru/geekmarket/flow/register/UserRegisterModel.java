package ru.geekmarket.flow.register;

import java.io.Serializable;

public class UserRegisterModel implements Serializable {

    private BasicUserInfo basicUserInfo;

    private PersonalUserInfo personalUserInfo;

    public void setBasicUserInfo(BasicUserInfo basicUserInfo) {
        this.basicUserInfo = basicUserInfo;
    }

    public BasicUserInfo getBasicUserInfo() {
        return basicUserInfo;
    }

    public void setPersonalUserInfo(PersonalUserInfo personalUserInfo) {
        this.personalUserInfo = personalUserInfo;
    }

    public PersonalUserInfo getPersonalUserInfo() {
        return personalUserInfo;
    }
}
