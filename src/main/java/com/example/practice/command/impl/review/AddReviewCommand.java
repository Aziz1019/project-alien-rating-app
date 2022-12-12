package com.example.practice.command.impl.review;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.exception.ServiceException;
import com.example.practice.model.Review;
import com.example.practice.service.AlienService;
import com.example.practice.service.ReviewService;
import com.example.practice.service.UserService;
import com.example.practice.service.impl.AlienServiceImpl;
import com.example.practice.service.impl.ReviewServiceImpl;
import com.example.practice.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class AddReviewCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        ReviewService service = ReviewServiceImpl.getInstance();
        AlienService alienService = AlienServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();

        String review = request.getParameter("review");

        Integer intAlien = Integer.parseInt(request.getParameter("alien_id"));
        Integer intUserId = Integer.parseInt(request.getParameter("user_id"));
        Integer intRating = Integer.parseInt(request.getParameter("rate"));


        Integer numberOfRating = service.getNumberOfRating(intAlien);
        Double averageRating;
        if (numberOfRating > 0) {
            averageRating = service.getAverageRating(intAlien);
            service.saveDB(new Review(intUserId, review, intAlien, intRating));

        } else {
            service.saveDB(new Review(intUserId, review, intAlien, intRating));
            averageRating = service.getAverageRating(intAlien);
        }

        if (averageRating >= 3.5) {
            updateStatus(userService, intUserId, intRating >= averageRating);
        } else {
            updateStatus(userService, intUserId, intRating <= averageRating);
        }
        request.setAttribute("aliens", alienService.getAliens());
        return "pages/user/views/alien-page.jsp";
    }

    private void updateStatus(UserService userService, Integer userId, boolean b) {
        userService.updateStatus(b, userId);
    }
}
