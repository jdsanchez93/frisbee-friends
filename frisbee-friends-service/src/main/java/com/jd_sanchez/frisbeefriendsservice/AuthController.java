package com.jd_sanchez.frisbeefriendsservice;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/api/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("login"));
    }

    // @Autowired
    // private OAuth2AuthorizedClientService authorizedClientService;

    // @GetMapping("/api/login")
    // public String index(Authentication authentication) {
    //     OAuth2AuthorizedClient authorizedClient =
    //         this.authorizedClientService.loadAuthorizedClient("github", authentication.getName());
    //     OAuth2AccessToken accessToken = authorizedClient.getAccessToken();

    //     return "index";
    // }
}
