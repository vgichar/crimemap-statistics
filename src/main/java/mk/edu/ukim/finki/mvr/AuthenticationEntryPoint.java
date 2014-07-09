package mk.edu.ukim.finki.mvr;

import java.io.IOException;
import org.springframework.security.core.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class AuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {    
    public AuthenticationEntryPoint(String loginUrl)  {
        super(loginUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.sendError(403, "Forbidden");
    }
}
