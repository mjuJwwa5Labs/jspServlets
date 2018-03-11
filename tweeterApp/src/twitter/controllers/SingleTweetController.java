package twitter.controllers;

import twitter.dto.TwitterMessageDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SingleTweetController", value="/tweet")
public class SingleTweetController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tweetIdAsString = req.getParameter("tweetId");
        Integer tweetId = Integer.valueOf(tweetIdAsString);

        TwitterMessageDto twitterMessageDto1 = new TwitterMessageDto(1,"first message", "mike");
        TwitterMessageDto twitterMessageDto2 = new TwitterMessageDto(2,"second message", "john");

        Map<Integer, TwitterMessageDto> twitterMap = new HashMap<>();
        twitterMap.put(twitterMessageDto1.getId(),twitterMessageDto1);
        twitterMap.put(twitterMessageDto2.getId(),twitterMessageDto2);

        //todo DAO do getTweetById()
        TwitterMessageDto foundTweet = twitterMap.get(tweetId);

        req.setAttribute("singleTweetModel", foundTweet);

        RequestDispatcher dispatcher = req.getRequestDispatcher("tweets/tweet.jsp");
        dispatcher.forward(req,resp);
    }
}
