package com.example.practice.command.impl.user.register;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.exception.ServiceException;
import com.example.practice.model.User;
import com.example.practice.service.UserService;
import com.example.practice.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        UserService service = UserServiceImpl.getInstance();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repass = request.getParameter("repass");
        String page;
        if (repass.equals(password)) {
            service.registerUser(new User(username, password));
            page = "index.jsp";
        } else {
            page = "pages/user/register.jsp";
        }
        return page;
    }
}
