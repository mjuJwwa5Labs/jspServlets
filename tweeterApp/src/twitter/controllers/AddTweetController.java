package twitter.controllers;

import twitter.dto.TwitterMessageDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddTweetController", value="/addTweet")
public class AddTweetController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("singleTweetModel", new TwitterMessageDto());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/tweets/tweet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tweetMessage = req.getParameter("message");
        String userName = req.getParameter("username");

        //todo zapisywanie tweeta do bazy danych

        String message = "Użytkowniku " + userName + " dodałeś tweeta o wiadomości: \n" + tweetMessage;
        req.setAttribute("message", message);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/tweets/message/message.jsp");
        requestDispatcher.forward(req,resp);
    }
}
