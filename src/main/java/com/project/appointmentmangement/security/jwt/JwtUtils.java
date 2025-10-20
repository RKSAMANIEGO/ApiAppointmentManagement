package com.project.appointmentmangement.security.jwt;

import org.springframework.stereotype.Component;
import javax.crypto.spec.SecretKeySpec;
import java.util.function.Function;
import io.jsonwebtoken.*;
import java.security.Key;
import java.util.*;

@Component
public class JwtUtils {

    private static final String KEY_SECRET = "enrikerodkelersamaniegoguzmanenrikerodkelersamaniegoguzmanenrikerodkelersamaniegoguzman";

    public String generatedToken(String username){
        return Jwts.builder().setSubject(username)
                            .setIssuedAt(new Date(System.currentTimeMillis() ) )
                            .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60))
                            .signWith(SignatureAlgorithm.HS256, getKey())
                            .compact();
    }

    public String getSubjectFromToken(String token){
        return getClaims(token, Claims::getSubject);
    }

    public Date getDateExpirationFromToken(String token){
        return getClaims(token, Claims::getExpiration);
    }

    public Boolean isTokenExpired(String token, String username){
        return getSubjectFromToken(token).equals(username) && !( getDateExpirationFromToken(token).before(new Date()) );
    }

    public <T> T getClaims(String token, Function<Claims,T> claimsTFunction){
        return claimsTFunction.apply(getAllClaims(token));
    }
    public Claims getAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
    }

    public Key getKey(){
        byte[] encoded = Base64.getEncoder().encode(KEY_SECRET.getBytes());
        return new SecretKeySpec(encoded, SignatureAlgorithm.HS256.getJcaName());
    }

}
