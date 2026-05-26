package com.satyam.SpringSecurity.service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    //HardCoding Key (not a encyrpted key)
    private static final String SECRET = "TwteuiB7HUDDJnm&Edhbsoi";

    //Randomly generation keys
    private final String secretKey;

    public JwtService() {
        secretKey = generateSecretKey();
    }

    public String generateSecretKey(){
        try{
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();
            System.out.println("SECRET: "+secretKey.toString());
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());   //encoding key


        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            throw new RuntimeException("SecretKey cant be genereated");
        }
    }


    public String generateToken(String username) {

        //Get every Claims(userinfo)
        Map<String, Object> claims = new HashMap<>();


        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000*60*2))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();   //compact everything into a string


        /** HEADER + PAYLOAD + SECRET_KEY
         ↓
         SHA256 HMAC
         ↓
         SIGNATURE
         **/
    }

    private Key getKey(){

        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
