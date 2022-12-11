package com.example.practice.command.impl.user;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import javax.servlet.http.HttpServletRequest;

public class ForwardMainPageCommand implements Command {
    String page = "pages/errors/login-error.jsp";
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String main = request.getParameter("main");
        if(main.equals("main_user")){
            page = "pages/user/views/user-logged-page.jsp";
        }
        else if (main.equals("main_admin")) {
            page = "pages/admin/admin-logged-page.jsp";
        }
        return page;
    }
}
