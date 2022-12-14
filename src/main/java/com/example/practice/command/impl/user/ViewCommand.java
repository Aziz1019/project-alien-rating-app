package com.example.practice.command.impl.user;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.exception.ServiceException;
import com.example.practice.service.UserService;
import com.example.practice.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class ViewCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) throws CommandException {
        UserService service = UserServiceImpl.getInstance();
        String page;
        if (req.getParameter("block").equals("0")) {
            req.setAttribute("users", service.getAll());
            page = "pages/admin/views/view-users.jsp";
        } else if (req.getParameter("block").equals("1")) {
            req.setAttribute("users", service.getAllUsers());
            page = "pages/user/views/view-by-status.jsp";

        } else {
            req.setAttribute("users", service.getAllBlockedUsers());
            page = "pages/admin/views/view-blocked-users.jsp";
        }
        return page;
    }
}
