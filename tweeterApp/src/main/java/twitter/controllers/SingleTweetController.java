package twitter.controllers;

import twitter.dto.TwitterMessageDto;
import twitter.service.TwitterMessageService;
import twitter.service.TwitterMessageServiceDbImpl;
import twitter.service.TwitterMessageServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SingleTweetController", value="/tweet")
public class SingleTweetController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tweetIdAsString = req.getParameter("tweetId");
        Integer tweetId = Integer.valueOf(tweetIdAsString);

//        TwitterMessageService twitterMessageService = new TwitterMessageServiceImpl();
        TwitterMessageService twitterMessageService = new TwitterMessageServiceDbImpl();
        TwitterMessageDto foundTweet = twitterMessageService.fingById(tweetId);

        if (foundTweet==null) {
            req.setAttribute("errorMessage", "Nie znaleziono wskazanego tweeta o id " + tweetId);
        }

        req.setAttribute("singleTweetModel", foundTweet);

        RequestDispatcher dispatcher = req.getRequestDispatcher("tweets_jstl/tweet.jsp");
        dispatcher.forward(req,resp);
    }
}
