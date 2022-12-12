package com.example.practice.command.impl.review;

import com.example.practice.command.Command;
import com.example.practice.exception.CommandException;
import com.example.practice.model.Alien;
import com.example.practice.service.AlienService;
import com.example.practice.service.ReviewService;
import com.example.practice.service.impl.AlienServiceImpl;
import com.example.practice.service.impl.ReviewServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class ForwardReviewCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        ReviewService service = ReviewServiceImpl.getInstance();
        AlienService alienService = AlienServiceImpl.getInstance();

        String page = request.getParameter("page");
        HttpSession session = request.getSession();
        String path = null;
        switch (page) {
            case "admin":
                request.setAttribute("reviews", service.getReviews());
                path = "pages/admin/views/review-page.jsp";
                break;
            case "add_review":
                Optional<Alien> alienId1 = alienService.findById(Long.parseLong(request.getParameter("alien_id")));

                String alienId = request.getParameter("alien_id");
                String userId = request.getParameter("user_id");

                session.setAttribute("alien_id", alienId);
                session.setAttribute("user_id", userId);
                alienId1.ifPresent(alien -> session.setAttribute("alien", alien));
                path = "pages/user/add-review.jsp";
                break;
            case "user":
                request.setAttribute("reviews", service.getAllReviews());
                path = "pages/user/views/review-page.jsp";
                break;
        }
        return path;
    }
}
