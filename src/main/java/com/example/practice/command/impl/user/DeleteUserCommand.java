package com.example.practice.command.impl.user;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.exception.ServiceException;
import com.example.practice.service.UserService;
import com.example.practice.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) throws CommandException {
        UserService service = UserServiceImpl.getInstance();
        service.deleteById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("users", service.getAll());
        return "pages/admin/views/view-users.jsp";
    }
}
