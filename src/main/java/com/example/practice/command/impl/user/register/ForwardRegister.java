package com.example.practice.command.impl.user.register;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class ForwardRegister implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return "pages/user/register.jsp";
    }
}
