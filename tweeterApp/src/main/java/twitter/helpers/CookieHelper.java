package twitter.helpers;

import javax.servlet.http.Cookie;

public class CookieHelper {

    public static String getCookieValueByName(Cookie[] cookies, String cookieName) {
        String lang;
        if (cookies!=null) {
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals(cookieName)) {
                    lang = cookie.getValue();
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
