package com.example.practice.command.impl.user.update;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.exception.ServiceException;
import com.example.practice.model.User;
import com.example.practice.service.UserService;
import com.example.practice.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class UpdateFormCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        UserService service = UserServiceImpl.getInstance();

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String status = request.getParameter("status");
        String password = request.getParameter("password");
        String active = request.getParameter("active");
        String role = request.getParameter("role");
        String date = request.getParameter("date");
        User user = new User(
                Integer.parseInt(id),username,
                Integer.parseInt(status),
                Boolean.parseBoolean(active),
                role,date,password);

        try {
            service.update(user);
            request.setAttribute("users", service.getAll());
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return "pages/admin/views/view-users.jsp";
    }
}
