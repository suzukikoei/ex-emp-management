package com.example.form;

import jakarta.validation.constraints.NotBlank;

/**
 * ログイン時に使用するフォーム.
 */

public class LoginForm {

    /** メールアドレス　*/
    @NotBlank(message = "名前は必須入力です")
    private String mailAddress;

    /** パスワード　*/
    @NotBlank(message = "パスワードは必須入力です")
    private String password;

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "mailAddress='" + mailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
