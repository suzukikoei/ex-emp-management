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
 * */

@Repository
public class AdministrationRepository {

    /** 管理者を返すrow mapper. */
    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER =
            (rs, i) -> {
        Administrator administrator = new Administrator();
        administrator.setId(rs.getInt("id"));
        administrator.setName(rs.getString("name"));
        administrator.setMailAddress(rs.getString("mail_address"));
        administrator.setPassword(rs.getString("password"));
        return administrator;
            };

    /** ??? */
    @Autowired
    private NamedParameterJdbcTemplate template;


    /**
     * 管理者をDBにinsertする.
     *
     * @param administrator
     * @return なし
     * */
    public void insert(Administrator administrator){
        SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
        String sql = "INSERT INTO administrators (id, name, mail_address, password) VALUES " +
                "(:id, :name, :mail_address, :password)";
        template.update(sql, param);
    }

    /**
     * 管理者をDBにinsertする.
     *
     * @param mailAddress
     * @param password
     * @return 検索された管理者
     * */
    public Administrator findByMailAddressAndPassword(String mailAddress, String password){
        String sql = "SELECT * FROM administrators WHERE mail_address = :mail_address && password = :password";
        SqlParameterSource param = new MapSqlParameterSource();
        List<Administrator> administrators = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
        if(administrators.isEmpty()){
            return null;
        }
        return administrators.get(0);
    }

}
