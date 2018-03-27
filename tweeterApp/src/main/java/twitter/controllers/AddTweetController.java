package twitter.controllers;

import twitter.dto.TwitterMessageDto;
import twitter.service.TwitterMessageService;
import twitter.service.TwitterMessageServiceDbImpl;
import twitter.validators.Errors;
import twitter.validators.TwitterMessageValidator;
import twitter.validators.TwitterTitleValidator;
import twitter.validators.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AddTweetController", value="/addTweet")
public class AddTweetController extends HttpServlet {

    private List<Validator> validators = Arrays.asList(new TwitterTitleValidator(), new TwitterMessageValidator());
    private TwitterMessageService twitterMessageService = new TwitterMessageServiceDbImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("singleTweetModel", new TwitterMessageDto());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/tweets_jstl/tweet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tweetMessage = req.getParameter("message");
        String title = req.getParameter("title");

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String idParam = req.getParameter("id");
        Integer id;

        try {
            id = Integer.valueOf(idParam);
        } catch (NumberFormatException e) {
            id = null;
        }

        //to coś poniżej to się w Springu nazywa binding
        TwitterMessageDto twitterMessageDto = new TwitterMessageDto(id, tweetMessage, username, title);
        Errors errors = new Errors();
        for (Validator validator : validators) {
            validator.validate(twitterMessageDto,errors);
        }

        if (errors.hasFieldErrors()) {
            req.setAttribute("errors", errors);
            req.setAttribute("singleTweetModel", twitterMessageDto);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/tweets_jstl/tweet.jsp");
            requestDispatcher.forward(req,resp);
        } else {
            twitterMessageService.save(twitterMessageDto);
            String message = String.format("Drogi użytkowniku %s dodałeś tweeta o tytule %s i wiadomości %s",
                    username, title, tweetMessage);
            req.setAttribute("message", message);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/tweets_jstl/message/message.jsp");
            requestDispatcher.forward(req,resp);
        }

    }
}
