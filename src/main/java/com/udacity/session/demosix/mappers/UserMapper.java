package com.udacity.session.demosix.mappers;

import com.udacity.session.demosix.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser(String username);

    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES(#{username}, #{salt}, #{password}, #{firstname}, #{lastname})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    Integer insert(User user);

    @Delete("DELETE FROM USERS WHERE userid = #{id}")
    void delete(Integer id);
}
