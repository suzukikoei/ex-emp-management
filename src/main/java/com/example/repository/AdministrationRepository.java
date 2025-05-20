package com.example.repository;

import com.example.domain.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * administratorテーブルを操作するリポジトリ(Dao).
 */

@Repository
public class AdministrationRepository {

    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER =
            (rs, i) -> {
        Administrator administrator = new Administrator();
        administrator.setId(rs.getInt("id"));
        administrator.setName(rs.getString("name"));
        administrator.setMailAddress(rs.getString("mail_address"));
        administrator.setPassword(rs.getString("password"));
        return administrator;
            };

    @Autowired
    private NamedParameterJdbcTemplate template;


    /**
     * 管理者をDBに挿入する.
     *
     * @param administrator 管理者情報
     */
    public void insert(Administrator administrator){
        SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
        String sql = "INSERT INTO administrators (name, mail_address, password) VALUES " +
                "(:name, :mailAddress, :password);";
        template.update(sql, param);
    }

    /**
     * メールアドレスとパスワードから管理者情報を取得する.
     *　1件も存在しない場合はnullを返す。
     *
     * @param mailAddress メールアドレス
     * @param password パスワード
     * @return 検索された管理者
     */
    public Administrator findByMailAddressAndPassword(String mailAddress, String password){
        String sql = "SELECT * FROM administrators WHERE mail_address = :mailAddress && password = :password;";
        SqlParameterSource param = new MapSqlParameterSource();
        List<Administrator> administrators = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
        if(administrators.isEmpty()){
            return null;
        }
        return administrators.get(0);
    }

}
