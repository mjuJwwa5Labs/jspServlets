package twitter.controllers;

import twitter.exceptions.TwitterAuthorizationException;
import twitter.service.TwitterMessageService;
import twitter.service.TwitterMessageServiceDbImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteController", value = "/deleteTweet")
public class DeleteTweetController extends HttpServlet {

    private TwitterMessageService twitterMessageService = new TwitterMessageServiceDbImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("tweetId");
        Integer id;

        try {
            id = Integer.valueOf(idParam);
        } catch (NumberFormatException e) {
            id = null;
        }
        if (id!=null) {
            HttpSession session = req.getSession();
            String username = (String) session.getAttribute("username");
            try {
                twitterMessageService.delete(id,username);
                resp.sendRedirect("/tweets");
            } catch (TwitterAuthorizationException e) {
                req.setAttribute("errorMessage", "Dlaczego chcesz usuwać nie swojego tweeta?");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/tweets_jstl/message/message.jsp");
                dispatcher.forward(req,resp);
            }
        }
    }
}
