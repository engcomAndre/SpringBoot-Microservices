package academy.devdojo.youtube.auth.endpoint.controller;

import academy.devdojo.youtube.core.model.ApplicationUser;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("user")
public class UserInfoController {

    @GetMapping(value = "info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApplicationUser> getUserInfo(Principal principal) {
        ApplicationUser user = (ApplicationUser)((UsernamePasswordAuthenticationToken) principal).getPrincipal();

        return ResponseEntity.ok().body(user);
    }
}
