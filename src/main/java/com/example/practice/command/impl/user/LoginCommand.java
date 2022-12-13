package com.example.practice.command.impl.user;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.exception.ServiceException;
import com.example.practice.model.User;
import com.example.practice.service.UserService;
import com.example.practice.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        UserService userService = UserServiceImpl.getInstance();
        String login = request.getParameter("name");
        String pass = request.getParameter("password");
        String page;

        HttpSession session = request.getSession();

        if (userService.authenticate(login, pass)) {
            if (userService.isAdmin(login, pass)) {
                Integer adminId = userService.getIdByUsernameAndPassword(login, pass);
                session.setAttribute("user_name", login);
                session.setAttribute("id", adminId);
                page = "pages/admin/admin-logged-page.jsp";
            } else {
                Integer userId = userService.getIdByUsernameAndPassword(login, pass);
                session.setAttribute("user_name", login);
                session.setAttribute("id", userId);
                page = "pages/user/views/user-logged-page.jsp";
            }
        } else {
            page = "pages/errors/login-error.jsp";
        }
        return page;
    }
}
