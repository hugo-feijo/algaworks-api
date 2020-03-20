package com.hugo.algamoney.api.resource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tokens")
public class TokenResource {

	@DeleteMapping("/revoke")
	public void revoke(HttpServletRequest requeste, HttpServletResponse response) {
		Cookie refreshTokenCookie = new Cookie("refreshToken", null);
		refreshTokenCookie.setHttpOnly(true);
		refreshTokenCookie.setSecure(true);//TODO: em produção será true
		refreshTokenCookie.setPath(requeste.getContextPath() + "/oauth/token");
		refreshTokenCookie.setMaxAge(0);
		
		response.addCookie(refreshTokenCookie);
		response.setStatus(HttpStatus.NO_CONTENT.value() );
	}
}
