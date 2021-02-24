package org.examle.crm;

import org.example.crm.settings.dao.UserDao;
import org.example.crm.settings.domain.User;
import org.example.crm.utils.MD5Util;
import org.example.crm.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qww
 * @Date 2021-02-24 13:55
 */
public class UserDaoTest {

    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
    @Test
    public void testSelectByNameAndPwd() {
        Map<String, String> map = new HashMap<>();
        map.put("loginAct", "ls");
        map.put("loginPwd", MD5Util.getMD5("123"));
        User user = userDao.selectByNameAndPwd(map);
        System.out.println(user);
    }

    @Test
    public void testSelectUserList() {
        List<User> userList = userDao.selectUserList();
        System.out.println(userList);
    }
}
