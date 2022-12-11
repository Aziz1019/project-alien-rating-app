package com.example.practice.command.impl.alien;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.service.AlienService;
import com.example.practice.service.impl.AlienServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class ViewAlienCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        AlienService service = AlienServiceImpl.getInstance();

        String page = request.getParameter("page");

        request.setAttribute("aliens", service.getAliens());

        if(page.equals("admin")){
            return "pages/admin/views/alien-page.jsp";
        }
        else {
            return "pages/user/views/alien-page.jsp";
        }
    }
}
