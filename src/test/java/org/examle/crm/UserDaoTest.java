package org.examle.crm;

import org.example.crm.settings.dao.UserDao;
import org.example.crm.settings.domain.User;
import org.example.crm.utils.MD5Util;
import org.example.crm.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qww
 * @Date 2021-02-24 13:55
 */
public class UserDaoTest {

    @Test
    public void testSelectByNameAndPwd() {
        UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
        Map<String, String> map = new HashMap<>();
        map.put("loginAct", "ls");
        map.put("loginPwd", MD5Util.getMD5("123"));
        User user = userDao.selectByNameAndPwd(map);
        System.out.println(user);
    }
}
