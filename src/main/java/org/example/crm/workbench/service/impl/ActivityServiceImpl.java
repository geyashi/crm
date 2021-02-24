package org.example.crm.workbench.service.impl;

import org.example.crm.settings.dao.UserDao;
import org.example.crm.settings.domain.User;
import org.example.crm.utils.SqlSessionUtil;
import org.example.crm.workbench.dao.ActivityDao;
import org.example.crm.workbench.service.ActivityService;

import java.util.List;

/**
 * @author qww
 * @Date 2021-02-24 20:17
 */
public class ActivityServiceImpl implements ActivityService {

    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public List<User> selectUserList() {
        return userDao.selectUserList();
    }
}
