package com.example.service;

import com.example.domain.Administrator;
import com.example.repository.AdministrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 管理者情報を操作するサービス.
 */

@Service
@Transactional
public class AdministratorService {
    @Autowired
    private AdministrationRepository administrationRepository;

    /**
     * 管理者情報を挿入する.
     *
     * @param administrator
     */
    public void insert(Administrator administrator){
        administrationRepository.insert(administrator);
    }

    /**
     * ログイン処理をする.
     *
     * @param mailAddress メールアドレス
     * @param password　パスワード
     * @return メールアドレスとパスワードで検索して得た管理者
     */
    public Administrator login(String mailAddress, String password){
        return administrationRepository.findByMailAddressAndPassword(mailAddress, password);
    }

}
