package SoulCode.Services.Security;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRACAO = 600_000;

}
