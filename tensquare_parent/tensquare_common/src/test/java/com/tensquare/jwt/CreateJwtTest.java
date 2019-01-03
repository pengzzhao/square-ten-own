package com.tensquare.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author pengzhao
 * @Title: CreateJwtTest
 * @ProjectName tensquare_parent
 * @Description: TODO
 * @date 2019/1/321:39
 */
public class CreateJwtTest {
    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("666")
                .setSubject("小马")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "itcast")
                .setExpiration(new Date(new Date().getTime() + 60 * 1000));
        System.out.println(jwtBuilder.compact());
    }
}
