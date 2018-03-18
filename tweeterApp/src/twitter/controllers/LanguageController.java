package twitter.controllers;

import twitter.enums.Language;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="LanguageController", value = "/language")
public class LanguageController extends HttpServlet{

    private final static int COOKIE_LANG_EXPIRE_IN_SECONDS_MINUTES_HOURS = 60 * 60 * 24;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String languageParameter = req.getParameter("lang");

        if (languageParameter!=null && !languageParameter.equals("")) {
            Language language = Language.valueOf(languageParameter);

            if (language!=null) {
                Cookie cookie = new Cookie("lang", language.getCountryCode());
                cookie.setMaxAge(COOKIE_LANG_EXPIRE_IN_SECONDS_MINUTES_HOURS);
                resp.addCookie(cookie);
                resp.sendRedirect("/myTweets");
            }
        }
    }
}
