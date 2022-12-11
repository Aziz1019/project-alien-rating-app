package com.example.practice.command.impl.alien;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.exception.ServiceException;
import com.example.practice.service.AlienService;
import com.example.practice.service.impl.AlienServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteAlienCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) throws CommandException {
        AlienService service = AlienServiceImpl.getInstance();
        service.deleteById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("aliens", service.getAliens());
        return "pages/admin/views/alien-page.jsp";
    }
}

