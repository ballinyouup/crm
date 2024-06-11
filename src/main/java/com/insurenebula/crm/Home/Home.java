package com.insurenebula.crm.Home;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class Home {

    @GetMapping("/")
    public Object getUserInfo(Authentication authentication) {
        if (authentication == null || !(authentication instanceof OAuth2AuthenticationToken)) {
            System.out.println("User not logged in. Redirecting!");
            return new RedirectView("http://localhost:8080/login");
        }
        
        return ResponseEntity.ok(authentication.getPrincipal());
    }

}