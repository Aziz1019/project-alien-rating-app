package com.example.practice.command.impl.review.update;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.model.Review;
import com.example.practice.service.ReviewService;
import com.example.practice.service.impl.ReviewServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class EditReviewCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        ReviewService service = ReviewServiceImpl.getInstance();
        Optional<Review> id = service.findById(Long.valueOf(request.getParameter("id")));
        id.ifPresent(r -> request.setAttribute("currentReview", r));
        return "pages/admin/edits/edit-review.jsp";
    }
}
