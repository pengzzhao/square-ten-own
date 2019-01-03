package com.tensquare.qa.interceptor;

import util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pengzhao
 * @Title: JwtInterceptor
 * @ProjectName tensquare_parent
 * @Description: TODO
 * @date 2019/1/323:02
 */

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        System.out.println("------经过拦截器--------");

        //拦截器只是复测把请求头包含token的令牌进行一个解析验证
        String header = request.getHeader("Authorization");
        if (!StringUtils.isEmpty(header)){
            if (header.startsWith("Bearer ")){
                //得到token
                String token = header.substring(7);
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");

                    if (roles != null && roles.equals("admin")){
                        request.setAttribute("claims_admin", token);
                    }

                    if (roles != null && roles.equals("user")){
                        request.setAttribute("claims_user", token);
                    }
                }catch (Exception e){
                    throw new RuntimeException("令牌不正确！");
                }
            }
        }
        return true;
    }
}
