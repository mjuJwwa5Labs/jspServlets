package twitter.filters;

import twitter.enums.Language;
import twitter.helpers.CookieHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = "/*")
public class LanguageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String lang = CookieHelper.getCookieValueByName(request.getCookies(), "lang");
        if (lang!=null && !lang.equals("")) {
            Language language = Language.valueOf(lang);
            request.setAttribute("language",language.getDescription());
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
