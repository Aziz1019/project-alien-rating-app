package com.example.practice.command.impl.user.update;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.exception.ServiceException;
import com.example.practice.model.User;
import com.example.practice.service.UserService;
import com.example.practice.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class EditFormCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) throws CommandException {
        UserService service = UserServiceImpl.getInstance();
        Optional<User> currentUser = null;
        try {
            currentUser = service.findById(Long.valueOf(req.getParameter("id")));
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        currentUser.ifPresent(user -> req.setAttribute("currentUser", user));
        return "pages/admin/edits/edit-user.jsp";
    }
}
