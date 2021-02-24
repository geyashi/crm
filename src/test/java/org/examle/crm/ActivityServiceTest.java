package org.examle.crm;

import org.example.crm.settings.domain.User;
import org.example.crm.utils.ServiceFactory;
import org.example.crm.utils.SqlSessionUtil;
import org.example.crm.workbench.dao.ActivityDao;
import org.example.crm.workbench.service.ActivityService;
import org.example.crm.workbench.service.impl.ActivityServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author qww
 * @Date 2021-02-24 20:37
 */
public class ActivityServiceTest {

    private ActivityService activityService = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

    @Test
    public void testSelectUserList() {
        List<User> userList = activityService.selectUserList();
        System.out.println(userList);
    }
}
