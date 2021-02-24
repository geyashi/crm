package org.example.crm.settings.dao;

import org.example.crm.settings.domain.User;

import java.util.Map;

/**
 * @author qww
 * @Date 2021-02-24 13:17
 */
public interface UserDao {

    User selectByNameAndPwd(Map<String, String> map);
}
