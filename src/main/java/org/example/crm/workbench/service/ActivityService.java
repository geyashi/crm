package org.example.crm.workbench.service;

import org.example.crm.settings.domain.User;

import java.util.List;

/**
 * @author qww
 * @Date 2021-02-24 20:17
 */
public interface ActivityService {
    List<User> selectUserList();

    void saveActivity();

}
