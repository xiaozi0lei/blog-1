package cn.sunguolei.blog.servicezuul.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static cn.sunguolei.blog.servicezuul.security.SecurityConstants.*;

@RestController
public class TokenController {
    private static Logger logger = LoggerFactory.getLogger(TokenController.class);

    @GetMapping("/getUserIdentity")
    public Map<String, String> getUserIdentity(HttpServletRequest request) {

        Map<String, String> userInfoMap = new HashMap<>();

        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // parse the token.
            String username;
            Claims body = Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            logger.debug(body.toString());
            username = body.getSubject();

            if (username != null) {
                userInfoMap.put("isLogin", "true");
                userInfoMap.put("username", username);
            }
        } else {
            userInfoMap.put("isLogin", "false");
        }
        return userInfoMap;
    }
}
