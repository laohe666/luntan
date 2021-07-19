package com.zl.luntan.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zl.luntan.dal.entity.User;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/10 23:22
 * copyright @2021 北京沐融信息科技股份有限公司
 */
public class JwtUtils {
    /**
     * 创建token
     * */
    public static String creatJwt(User user){
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.HOUR, 3);
        Date expiresDate = nowTime.getTime();
        return JWT.create().withAudience(String.valueOf(user.getUId()))
                .withIssuedAt(new Date())
                .withExpiresAt(expiresDate)
                .withClaim("email", user.getEmail())
                .withClaim("nickname", user.getNickname())
                .withClaim("headphoto", user.getHeadPhoto())
                .sign(Algorithm.HMAC256("woaifjj"));
    }

    /**
     * 检验合法性
     * */
    public static boolean verifyToken(String token){
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256("woaifjj")).build();
            jwt = verifier.verify(token);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 获取签发对象
     * */
    public static String getAudience(String token){
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException e) {
            return "getAudienceFalse";
        }
        return audience;
    }

    /**
     * 通过载荷名字获取载荷的值
     * */
    public static String getClaim(String token, String name){
        String claim = null;
        try {
            claim = String.valueOf(JWT.decode(token).getClaim(name));
        }catch (Exception e) {
            return "getClaimFalse";
        }
        return claim;
    }
}
