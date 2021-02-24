package org.example.crm.settings.service;

import org.example.crm.exception.LoginException;
import org.example.crm.settings.domain.User;

import java.util.Map;

/**
 * @author qww
 * @Date 2021-02-24 13:10
 */
public interface UserService {

    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
