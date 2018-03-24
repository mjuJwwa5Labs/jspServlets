package filters;

import dto.UserDto;
import entity.UserGroups;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter(value = "/logged/users/*")
public class UsersFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession httpSession = request.getSession();
        String login = (String) httpSession.getAttribute("login");
        Optional<UserDto> userDtoOptional = null;

        if (login!=null && login!="") {
            UserService userService = new UserServiceImpl();
            userDtoOptional = userService.getByLogin(login);
            if (userDtoOptional.isPresent()) {
                if (userService.isAdminGroup(userDtoOptional.get())) {
                    httpSession.setAttribute("userGroup", UserGroups.ADMIN);
                } else
                    httpSession.setAttribute("userGroup",UserGroups.USER);
            }
        }

        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
