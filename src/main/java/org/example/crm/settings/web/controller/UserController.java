package org.example.crm.settings.web.controller;

import org.example.crm.settings.domain.User;
import org.example.crm.settings.service.UserService;
import org.example.crm.settings.service.impl.UserServiceImpl;
import org.example.crm.utils.MD5Util;
import org.example.crm.utils.PrintJson;
import org.example.crm.utils.ServiceFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qww
 * @Date 2021-02-24 12:46
 */
public class UserController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if ("/settings/user/login.do".equals(path)) {
            login(req, resp);
        }else if ("/settings/user/register.do".equals(path)) {
            register(req, resp);
        }

    }

    private void register(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        // 获取浏览器提交的用户名、密码和ip
        String loginAct = req.getParameter("loginAct");
        String loginPwd = req.getParameter("loginPwd");
        String ip = req.getRemoteAddr();
        // 对密码MD5加密
        loginPwd = MD5Util.getMD5(loginPwd);

        // 动态代理生成UserService对象
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        try {
            // 调用service层的login
            User user = us.login(loginAct, loginPwd, ip);
            user.setLoginPwd(null);

            // 程序执行到此处，说明用户提交的信息正确，expireTime、lockState、ip检验通过
            // 将user写入session域
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            PrintJson.printJsonFlag(resp, true);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("success", false);
            map.put("msg", e.getMessage());
            PrintJson.printJsonObj(resp, map);
        }
    }
}
