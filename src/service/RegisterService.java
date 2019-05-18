package service;

import model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegisterService {

    private static RegisterService registerService;

    private static List<User> registeredUsers;

    private RegisterService() {
        registeredUsers = new ArrayList<>();
    }

    public static RegisterService getRegisterService() {
        if (Objects.isNull(registerService)) {
            registerService = new RegisterService();
        }

        return registerService;
    }

    public void registerUser(User user) {
        registeredUsers.add(user);
    }

    public boolean isPwdValid(String pwd, String checkPwd) {
        return StringUtils.isNotBlank(pwd) && StringUtils.isNotBlank(checkPwd) && pwd.equals(checkPwd);
    }

    public String printUsers() {
        if (!registeredUsers.isEmpty()) {
            return registeredUsers.toString();
        }
        return "No registered users!";
    }
}
