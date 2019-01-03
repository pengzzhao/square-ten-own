package com.tensquare.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * @author pengzhao
 * @Title: ParseJwtTest
 * @ProjectName tensquare_parent
 * @Description: TODO
 * @date 2019/1/321:44
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        Claims body = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1NDY1MjM1MjYsImV4cCI6MTU0NjUyMzU4Nn0.epFqQ3w1_RclMQk3UUikGNAn9EVk8Kctmtk1JYrZ8uU")
                .getBody();

        System.out.println("" + body.getId());
        System.out.println("" + body.getSubject());
        System.out.println("" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(body.getIssuedAt()));
        System.out.println("" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(body.getExpiration()));
    }
}
