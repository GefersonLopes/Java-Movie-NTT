package com.ntt.movie.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.movie.model.dto.TokenDTO;
import com.ntt.movie.service.AuthenticationService;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
  @Autowired
  private AuthenticationService authenticationService;

  @PostMapping("")
  public TokenDTO authenticate(
      @RequestBody
      Map<String, String> login) {
      String username = login.get("username");
      String password = login.get("password");

      UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
      String token = authenticationService.authenticate(authentication);
      
      TokenDTO tokenDTO = new TokenDTO();
      tokenDTO.setToken(token);
      
      return tokenDTO;
  }
}