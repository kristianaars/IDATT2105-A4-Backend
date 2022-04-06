package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, javax.servlet.FilterChain filterChain) throws ServletException, IOException {
        try {
            final Key key = Keys.hmacShaKeyFor(TokenService.TOKEN_KEY.getBytes());

            String tokenHeader;
            boolean validHeader =  ((tokenHeader = request.getHeader("Authorization")) != null)
                                    && tokenHeader.startsWith("Bearer ");

            if(!validHeader) {
                SecurityContextHolder.clearContext();
            } else {
                final String JWT_TOKEN = tokenHeader.replace("Bearer ", "");
                final Jws<Claims> CLAIMS = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(JWT_TOKEN);

                if(CLAIMS.getBody().get("authorities") != null) {
                    final List<String> AUTHORITIES = (List) CLAIMS.getBody().get("authorities");

                    final UsernamePasswordAuthenticationToken AUTH = new UsernamePasswordAuthenticationToken(
                            CLAIMS.getBody().getSubject(),
                            null,
                            AUTHORITIES.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                    );

                    SecurityContextHolder.getContext().setAuthentication(AUTH);
                } else {
                    SecurityContextHolder.clearContext();
                }
            }

            filterChain.doFilter(request, response);

        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
    }

}
