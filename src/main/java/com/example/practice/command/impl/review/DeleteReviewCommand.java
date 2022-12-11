package com.example.practice.command.impl.review;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.service.ReviewService;
import com.example.practice.service.impl.ReviewServiceImpl;
import javax.servlet.http.HttpServletRequest;

public class DeleteReviewCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        ReviewService service = ReviewServiceImpl.getInstance();
        service.deleteById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("reviews", service.getReviews());
        return "pages/admin/views/review-page.jsp";
    }
}
