package com.example.form;

import jakarta.validation.constraints.NotBlank;

/**
 * 管理者情報登録時に使用するフォーム.
 */

public class InsertAdministratorForm {
    /** 名前　*/
    @NotBlank(message = "名前は必須入力です")
    private String name;

    /** メールアドレス　*/
    @NotBlank(message = "メールアドレスは必須入力です")
    private String mailAddress;

    /** パスワード　*/
    @NotBlank(message = "パスワードは必須入力です")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        return "InsertAdministratorForm{" +
                "name='" + name + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
