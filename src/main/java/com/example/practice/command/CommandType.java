package com.example.practice.command;

import com.example.practice.command.impl.alien.DeleteAlienCommand;
import com.example.practice.command.impl.alien.add.AddAlienCommand;
import com.example.practice.command.impl.alien.add.ForwardAlienCommand;
import com.example.practice.command.impl.alien.ViewAlienCommand;
import com.example.practice.command.impl.alien.update.EditAlienCommand;
import com.example.practice.command.impl.alien.update.UpdateAlienCommand;
import com.example.practice.command.impl.review.AddReviewCommand;
import com.example.practice.command.impl.review.DeleteReviewCommand;
import com.example.practice.command.impl.review.ForwardReviewCommand;
import com.example.practice.command.impl.review.update.EditReviewCommand;
import com.example.practice.command.impl.review.update.UpdateReviewCommand;
import com.example.practice.command.impl.user.register.ForwardRegister;
import com.example.practice.command.impl.user.register.RegisterCommand;
import com.example.practice.command.impl.user.update.EditFormCommand;
import com.example.practice.command.impl.user.update.UpdateFormCommand;
import com.example.practice.command.impl.user.*;

public enum CommandType {
    /**
     * User commands
     */
    REGISTER(new RegisterCommand()),
    FORWARD_REGISTER(new ForwardRegister()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogOutCommand()),
    FORWARD_USER(new ForwardMainPageCommand()),
    /**
     * Admin commands
     */
    VIEW(new ViewCommand()),
    EDIT(new EditFormCommand()),
    UPDATE(new UpdateFormCommand()),
    BLOCK(new BlockUserCommand()),
    DELETE(new DeleteUserCommand()),
    /**
     * Alien commands
     */
    VIEW_ALIEN(new ViewAlienCommand()),
    FORWARD_ALIEN(new ForwardAlienCommand()),
    ADD_ALIEN(new AddAlienCommand()),
    UPDATE_ALIEN(new UpdateAlienCommand()),
    EDIT_ALIEN(new EditAlienCommand()),
    DELETE_ALIEN(new DeleteAlienCommand()),
    /**
     * Review commands
     */
    FORWARD_REVIEW(new ForwardReviewCommand()),
    ADD_REVIEW(new AddReviewCommand()),
    UPDATE_REVIEW(new UpdateReviewCommand()),
    EDIT_REVIEW(new EditReviewCommand()),
    DELETE_REVIEW(new DeleteReviewCommand());
    Command command;
    CommandType(Command command) {
        this.command = command;
    }
    public static Command define(String commandStr) {
        CommandType currentCommand = CommandType.valueOf(commandStr.toUpperCase());
        return currentCommand.command;
    }
}
