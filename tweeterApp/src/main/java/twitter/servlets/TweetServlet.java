package twitter.servlets;


import twitter.dto.TwitterMessageDto;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
@WebServlet(name = "TweetsServlet", value = "/tweetsHtmlServlet")
public class TweetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();

        TwitterMessageDto twitterMessageDto1 = new TwitterMessageDto(1,"first message", "mike", "pierwszy");
        TwitterMessageDto twitterMessageDto2 = new TwitterMessageDto(2,"second message", "john", "drugi");

        List<TwitterMessageDto> twitterList = new ArrayList<>();
        twitterList.add(twitterMessageDto1);
        twitterList.add(twitterMessageDto2);

        out.println("<html>");
        out.println("<body>");
        out.println("<div>Lista twiitów</div>");
        out.println("<ul>");
        //todo retrieve twitterList
        for (TwitterMessageDto message : twitterList) {
            out.print("<li><div>");
            out.print("id = " + message.getId() + ", ");
            out.print("message = " + message.getMessage() + ", ");
            out.print("username = " + message.getUsername());
            out.print("</div></li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}
