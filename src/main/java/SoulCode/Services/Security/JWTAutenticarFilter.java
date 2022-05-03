package SoulCode.Services.Security;

import SoulCode.Services.Data.DetalheUsuarioData;
import SoulCode.Services.model.UsuarioJWT;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRACAO = 600_000;

    public static final String TOKEN_SENHA = "8b63b3621eb5a3c5e39dfe2513097abe6fccd2cbecc29d8130d0686c88003f6a5281088fb6374ee201a32354c989f2cd5a20f928aec705d82be1eaa0b93dea1a";

    private final AuthenticationManager authenticationManager;

    public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    // o método attemptAuthentication faz a tentativa de autenticação.
    // Nesse momento é verificado a autenticidade do username e password do usuário.

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UsuarioJWT usuario = new ObjectMapper().readValue(request.getInputStream(), UsuarioJWT.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                   usuario.getLogin(),
                   usuario.getPassword(),
                   new ArrayList<>()));

            } catch (IOException e) {
                throw new RuntimeException("Falha ao tentar autenticar o usuário", e);

        }
    }

    @Override
    protected void successfulAuthentication
            (HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {

        DetalheUsuarioData usuarioData = (DetalheUsuarioData) authResult.getPrincipal();
        String token = JWT.create()
                .withSubject(usuarioData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
                .sign(Algorithm.HMAC512(TOKEN_SENHA));

        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, PATCH, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.getWriter().write("{\"Authorization\": \"" + token + "\"}");
        response.getWriter().flush();

    }


}
