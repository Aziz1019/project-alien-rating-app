package com.example.practice.command.impl.alien.add;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.model.Alien;
import com.example.practice.service.AlienService;
import com.example.practice.service.impl.AlienServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class AddAlienCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        AlienService service = AlienServiceImpl.getInstance();

        String alien_name = request.getParameter("alien_name");
        String source = request.getParameter("source");
        String admin_name = request.getParameter("admin_name");
        String image_url = request.getParameter("image_url");

        service.saveDB(new Alien(alien_name, source, admin_name,image_url));

        request.setAttribute("aliens", service.getAliens());
        return "pages/admin/views/alien-page.jsp";
    }
}
