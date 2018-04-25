package com.liquidli.ms.core.login.util;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * 用户登录保持Token生成类
 * 
 * @author liqi
 *
 */
@Component
public class TokenGenerator {

	private static final String JWT_HCMA_SECRET = "secret_9988765";

	private static final String JWT_ISSUER = "core_login";

	private static final String KEY_USERID = "userID";

	@Value("${core.login.token.timeout}")
	private Long tokenTimeOut;

	public String genToken(GenMethod genMethod, String userId) {
		if (genMethod == GenMethod.JWT) {
			return genJWTToken(userId);
		}
		return genJWTToken(userId);
	}

	public String verifyTokenForUserId(GenMethod genMethod, String token) {
		String userId = null;
		try {
			Algorithm algorithm = Algorithm.HMAC256(JWT_HCMA_SECRET);
			JWTVerifier verifier = JWT.require(algorithm).withIssuer(JWT_ISSUER).acceptLeeway(1).build();
			DecodedJWT jwt = verifier.verify(token);
			userId = jwt.getClaim(KEY_USERID).asString();
		} catch (IllegalArgumentException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return userId;
		}
		return userId;
	}

	private String genJWTToken(String userId) {
		String token = null;
		try {
			Algorithm algorithm = Algorithm.HMAC256(JWT_HCMA_SECRET);
			Builder jwtBuilder = JWT.create().withIssuer(JWT_ISSUER).withClaim(KEY_USERID, userId);
			if (tokenTimeOut != null && tokenTimeOut > 0L) {
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.SECOND, tokenTimeOut.intValue());
				jwtBuilder.withExpiresAt(cal.getTime());
			}
			token = jwtBuilder.sign(algorithm);

		} catch (IllegalArgumentException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return token;
	}

	/**
	 * 
	 * @author liqi
	 *
	 */
	public static enum GenMethod {
		JWT;
	}
}
