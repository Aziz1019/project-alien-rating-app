package com.example.practice.command.impl.alien.update;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.model.Alien;
import com.example.practice.service.AlienService;
import com.example.practice.service.impl.AlienServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class UpdateAlienCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        AlienService service = AlienServiceImpl.getInstance();
        String id = request.getParameter("id");
        String alienName = request.getParameter("alien_name");
        String source = request.getParameter("source");
        String imageUrl = request.getParameter("image_url");

        service.update(new Alien(Integer.parseInt(id), alienName, source, imageUrl));

        request.setAttribute("aliens", service.getAliens());
        return "pages/admin/views/alien-page.jsp";
    }
}
