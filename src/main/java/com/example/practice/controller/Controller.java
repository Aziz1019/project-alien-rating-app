package com.example.practice.controller;

import com.example.practice.command.Command;
import com.example.practice.command.CommandType;
import com.example.practice.exception.CommandException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {

    //    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String commandStr = req.getParameter("command");
//        Command command = CommandType.define(commandStr);
//        String page;
//
//        try {
//            page = command.execute(req);
//            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
//            dispatcher.forward(req,resp);
//
//        } catch (CommandException e) {
//            req.setAttribute("error_msg", e.getCause());
//            req.getRequestDispatcher("pages/error/error_500.jsp").forward(req, resp);
//        }
//
//    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        String commandStr = req.getParameter("command");
        Command command = CommandType.define(commandStr);
        String page;
        try {
            page = command.execute(req);
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, res);

        } catch (CommandException e) {
            req.setAttribute("error_msg", e.getCause());
            req.getRequestDispatcher("pages/error/error_500.jsp").forward(req, res);
        }
    }

}