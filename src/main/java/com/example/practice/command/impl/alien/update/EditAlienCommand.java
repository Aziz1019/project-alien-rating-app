package com.example.practice.command.impl.alien.update;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.model.Alien;
import com.example.practice.service.AlienService;
import com.example.practice.service.impl.AlienServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class EditAlienCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        AlienService service = AlienServiceImpl.getInstance();
        Optional<Alien> alien = service.findById(Long.valueOf(request.getParameter("id")));
        alien.ifPresent(a -> request.setAttribute("currentAlien", a));
        return "pages/admin/edits/edit-alien.jsp";
    }
}
