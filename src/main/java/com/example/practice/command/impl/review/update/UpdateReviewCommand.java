package com.example.practice.command.impl.review.update;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.model.Review;
import com.example.practice.service.ReviewService;
import com.example.practice.service.impl.ReviewServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class UpdateReviewCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        ReviewService service = ReviewServiceImpl.getInstance();
        String id = request.getParameter("id");
        String userId = request.getParameter("user_id");
        String alien_id = request.getParameter("alien_id");
        String review = request.getParameter("review");
        String rating = request.getParameter("rating");
        service.update(new Review(Integer.parseInt(id),Integer.parseInt(userId), review, Integer.parseInt(alien_id), Integer.parseInt(rating)));

        request.setAttribute("reviews", service.getReviews());
        return "pages/admin/views/review-page.jsp";
    }
}
