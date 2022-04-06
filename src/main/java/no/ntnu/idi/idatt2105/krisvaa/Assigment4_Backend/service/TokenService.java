package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model.UserAccount;
import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class TokenService {

    public final static String TOKEN_KEY = "tokensecurekeyblablablacurekeyblablabcurekeyblablabcurekeyblablabblablablabla";
    private final int TOKEN_LIFESPAN = 6000000;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    public TokenService() {
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public String authenticateUser(String username, String password) {
        UserAccount authenticatedUser = userAccountRepository.getUserWithCreds(username, password);

        if(authenticatedUser != null) {
            return generateToken(authenticatedUser.getUser_id());
        } else {
            return null;
        }
    }

    /**
     * Generates a new token for the provided userId.
     *
     * @param userID User id to be added to token.
     * @return Token-string with user id.
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public String generateToken(final long userID) {
        Key key = Keys.hmacShaKeyFor(TOKEN_KEY.getBytes(StandardCharsets.UTF_8));
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        Claims claims = Jwts.claims().setSubject(userID+"");
        claims.put("userId", userID);
        claims.put("authorities", grantedAuthorities
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(userID+"")
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000000))
                .signWith(key)
                .compact();    }



}
