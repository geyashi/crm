package org.example.crm.workbench.web.controller;

import org.example.crm.settings.domain.User;
import org.example.crm.settings.service.UserService;
import org.example.crm.settings.service.impl.UserServiceImpl;
import org.example.crm.utils.*;
import org.example.crm.workbench.domain.Activity;
import org.example.crm.workbench.service.ActivityService;
import org.example.crm.workbench.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qww
 * @Date 2021-02-24 19:35
 */
public class ActivityController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("======> 市场活动ActivityController <======");
        String path = req.getServletPath();
        if ("/workbench/activity/getUserList.do".equals(path)) {
            getUserList(req, resp);
        }else if ("/workbench/activity/save.do".equals(path)) {
            saveActivity(req, resp);
        }

    }

    private void saveActivity(HttpServletRequest req, HttpServletResponse resp) {
        String id = UUIDUtil.getUUID();
        String owner = req.getParameter("owner");
        String name = req.getParameter("name");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String cost = req.getParameter("cost");
        String description = req.getParameter("description");
        String createTime = DateTimeUtil.getSysTime();
        String createBy = req.getParameter("createBy");
        Activity activity = new Activity();
        activity.setId(id);
        activity.setOwner(owner);
        activity.setName(name);
        activity.setStartDate(startDate);
        activity.setEndDate(endDate);
        activity.setCost(cost);
        activity.setDescription(description);
        activity.setCreateTime(createTime);
        activity.setCreateBy(createBy);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        as.saveActivity();
    }

    private void getUserList(HttpServletRequest req, HttpServletResponse resp) {
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        List<User> userList = as.selectUserList();
        PrintJson.printJsonObj(resp, userList);
    }

}
