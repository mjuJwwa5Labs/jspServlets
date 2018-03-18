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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name="MyTweetsController", value="/myTweets")
public class MyTweetsController extends HttpServlet {

    private TwitterMessageService twitterMessageService = new TwitterMessageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        List<TwitterMessageDto> myTweets = twitterMessageService.findByUser(username);
        req.setAttribute("myTweets", myTweets);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/tweets_jstl/myTweets.jsp");
        requestDispatcher.forward(req,resp);
    }
}
