package twitter.servlets;


import twitter.dto.TwitterMessageDto;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Deprecated
@WebServlet(name = "SingleTweetServlet", value = "/tweetSingleHtmlServlet")
public class SingleTweetServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        String tweetIdAsString = req.getParameter("tweetId");
        Integer tweetId = Integer.valueOf(tweetIdAsString);

        TwitterMessageDto twitterMessageDto1 = new TwitterMessageDto(1,"first message", "mike", "pierwszy");
        TwitterMessageDto twitterMessageDto2 = new TwitterMessageDto(2,"second message", "john", "drugi");

        Map<Integer, TwitterMessageDto> twitterMap = new HashMap<>();
        twitterMap.put(twitterMessageDto1.getId(),twitterMessageDto1);
        twitterMap.put(twitterMessageDto2.getId(),twitterMessageDto2);

        //todo DAO do getTweetById()
        TwitterMessageDto foundTweet = twitterMap.get(tweetId);

        out.println("<html>");
        out.println("<body>");
        out.println("<div>Lista twiitów</div>");
        out.println("<div>");
            out.println("<form>");
            out.println("<input type=\"text\" name=\"message\" value=\""+foundTweet.getMessage()+"\"/>");
            out.println("<input type=\"text\" name=\"username\" value=\""+foundTweet.getUsername()+"\"/>");
            out.println("<input type=\"hidden\" name=\"id\" value=\"\"/>");
            out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }
}
