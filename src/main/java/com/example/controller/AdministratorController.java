package com.example.controller;

import com.example.form.InsertAdministratorForm;
import com.example.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理者登録画面を表示するフォーム.
 */

@Controller
@RequestMapping("/")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    /**
     * 管理者情報を登録する画面にフォワードする.
     *
     * @param form 管理者登録情報入力フォーム
     * @return administrator/insert 登録画面
     */
    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form) {
        return "administrator/insert";
    }
}
