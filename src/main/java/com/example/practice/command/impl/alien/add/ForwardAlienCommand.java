package com.example.practice.command.impl.alien.add;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class ForwardAlienCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return "pages/admin/add-alien.jsp";
    }
}
