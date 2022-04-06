package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.controller;

import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/token")
@EnableAutoConfiguration
@CrossOrigin
public class UserController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("")
    public String getToken(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password,
            HttpServletResponse response
    ) {

        return tokenService.authenticateUser(username, password);
    }
}
