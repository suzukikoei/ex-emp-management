package com.example.controller;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理者情報を操作するコントローラ.
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private HttpSession session;

    /**
     * 管理者情報を登録する画面にフォワードする.
     *
     * @param form 管理者登録情報入力フォーム
     * @return 登録画面
     */
    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form) {
        return "administrator/insert";
    }

    /**
     * 管理者情報を登録し、ログイン画面にフォワードする.
     *
     * @param form 管理者情報入力フォーム
     * @return ログイン画面
     */
    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form){
        ModelMapper modelMapper = new ModelMapper();
        Administrator administrator = modelMapper.map(form, Administrator.class);
        administratorService.insert(administrator);
        return "administrator/login";
    }

    /**
     * ログイン画面にフォワードする.
     *
     * @param form 管理者情報を入力するフォーム
     * @return ログイン画面
     */
    @GetMapping("/")
    public String toLogin(LoginForm form){
        return "administrator/login";
    }

    /**
     * ログイン処理をする.
     *
     * @param form メールアドレスとパスワードが入ったフォーム
     * @param model リクエストスコープ
     * @return 従業員一覧画面
     */
    @PostMapping("/login")
    public String login(LoginForm form, Model model){
        String mailAddress = form.getMailAddress();
        String password = form.getPassword();
        Administrator administrator = administratorService.login(mailAddress, password);
        if(administrator == null){
            model.addAttribute("message", "メールアドレスまたはパスワードが不正です。");
            return "administrator/login";
        }
        session.setAttribute("administratorName", administrator.getName());
        return "redirect:/employee/showList";
    }

}
