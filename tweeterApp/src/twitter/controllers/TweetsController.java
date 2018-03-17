package twitter.controllers;

import twitter.dto.TwitterMessageDto;
import twitter.service.TwitterMessageService;
import twitter.service.TwitterMessageServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="TweetsController", value = "/tweets")
public class TweetsController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TwitterMessageService twitterMessageService = new TwitterMessageServiceImpl();
        List<TwitterMessageDto> twitterList = twitterMessageService.findAll();
        req.setAttribute("tweetsModel", twitterList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/tweets_jstl/tweets.jsp");
        dispatcher.forward(req,resp);
    }
}
