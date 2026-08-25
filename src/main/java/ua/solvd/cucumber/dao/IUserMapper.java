package ua.solvd.cucumber.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ua.solvd.cucumber.model.User;

public interface IUserMapper {

    @Select("SELECT id, username, password, first_name AS firstName, last_name AS lastName, zip_code AS zipCode " +
            "FROM users WHERE username = #{username}")
    User getUserByUsername(@Param("username") String username);
}