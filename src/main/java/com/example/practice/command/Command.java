package com.example.practice.command;

import com.example.practice.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request) throws CommandException;
}
