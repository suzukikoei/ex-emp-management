package com.example.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * 従業員情報更新時に使用するフォーム.
 */
public class UpdateEmployeeForm {
    /** ID */
    private String id;

    /** 扶養人数　*/
    @NotBlank(message = "扶養人数は必須です")
    @Pattern(regexp = "^[0-9]+$", message = "扶養人数は数値で入力してください")
    private String dependentsCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDependentsCount() {
        return dependentsCount;
    }

    public void setDependentsCount(String dependentsCount) {
        this.dependentsCount = dependentsCount;
    }

    @Override
    public String toString() {
        return "UpdateEmployeeForm{" +
                "id='" + id + '\'' +
                ", dependentsCount='" + dependentsCount + '\'' +
                '}';
    }
}
