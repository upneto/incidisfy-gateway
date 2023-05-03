package br.com.incidisfy.resources.utils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.security.auth.login.LoginException;

import br.com.incidisfy.resources.exception.AutenticatorException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public final class JwtUtils {

	/**
	 * Chave da criptografia
	 */
	private static final String SECRET = "BwyAnkAUDOzZm+mAUdCMDMPV8o3RfczNzQBbHgiLGiA=";
	
	/**
	 * Tempo de duração do token (sessão do usuário)
	 */
	private static final long TIME_TO_EXPIRE = 60L; 
	
	/**
	 * 
	 * @return
	 */
	public static final JwtUtils getInstance() {
		return new JwtUtils();
	}
	
	/**
	 * Gera JWT
	 * @param usuario
	 * @return
	 */
	public final String getToken(String usuario) {
		return "Bearer " + Jwts.builder()
				.setSubject(usuario)
				.setIssuer("fmba-backent-user")
				.setIssuedAt(new Date())
				.setExpiration(Date.from(LocalDateTime.now().plusMinutes(TIME_TO_EXPIRE).atZone(ZoneId.systemDefault()).toInstant()))
				.signWith(Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8)))
				.compact();
	}
	
	/**
	 * Valida JWT
	 * @param token
	 * @return
	 * @throws LoginException
	 */
	public final boolean validateToken(String token) throws AutenticatorException {
		final String _TOKEN = token.substring("Bearer".length()).trim();
		try {
			Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8))).build().parseClaimsJws(_TOKEN);
			return true;
		} catch (Exception e) {
			throw new AutenticatorException("Sessão encerrada! Favor efetivar novo login.", e);
		}
	}
}
