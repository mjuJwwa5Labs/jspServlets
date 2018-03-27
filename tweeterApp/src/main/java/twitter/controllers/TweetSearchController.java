package twitter.controllers;


import twitter.dto.SearchTwitterMessageDto;
import twitter.dto.TwitterMessageDto;
import twitter.service.TwitterMessageService;
import twitter.service.TwitterMessageServiceDbImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TweetSearchController", value = "/tweets/search")
public class TweetSearchController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchUsername = req.getParameter("searchUsername");
        String searchMessage = req.getParameter("searchMessage");
        String searchTitle = req.getParameter("searchTitle");
        SearchTwitterMessageDto searchTwitterMessageDto = new SearchTwitterMessageDto(searchTitle,searchMessage,searchUsername);

        TwitterMessageService twitterService = new TwitterMessageServiceDbImpl();

        List<TwitterMessageDto> foundTweets = twitterService.findTweet(searchTwitterMessageDto);

        req.setAttribute("tweetsModel", foundTweets);
        req.setAttribute("resultsCount", String.valueOf(foundTweets.size()));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/tweets_jstl/tweets.jsp");
        dispatcher.forward(req,resp);
    }
}
