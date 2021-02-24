package org.example.crm.settings.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.crm.exception.LoginException;
import org.example.crm.settings.dao.UserDao;
import org.example.crm.settings.domain.User;
import org.example.crm.settings.service.UserService;
import org.example.crm.utils.DateTimeUtil;
import org.example.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qww
 * @Date 2021-02-24 13:11
 */
public class UserServiceImpl implements UserService {
    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException {
        User userByDB = null;
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String, String> map = new HashMap<>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);
        userByDB = userDao.selectByNameAndPwd(map);
        if (userByDB == null) {
            throw new LoginException("用户名或密码错误");
        }

        if (!userByDB.getAllowIps().contains(ip)) {
            throw new LoginException("ip受限");
        }

        if (DateTimeUtil.getSysTime().compareTo(userByDB.getExpireTime()) < 0) {
            throw new LoginException("账户已过期");
        }

        if ("0".equals(userByDB.getLockState())) {
            throw new LoginException("账户已锁定");
        }

        return userByDB;
    }
}
