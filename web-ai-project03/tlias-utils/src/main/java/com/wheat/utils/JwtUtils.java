package com.wheat.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 与测试类中一致的密钥 (Base64 Encoded "wheat")
    private static final String SECRET_KEY = "d2hlYXQ=";

    // 令牌过期时间：12小时
    private static final long EXPIRATION_MILLIS = 1000L * 60 * 60 * 12;

    /**
     * 生成 JWT 令牌
     *
     * @param claimsMap 需要放入 payload 的自定义数据
     * @return 生成的 JWT 字符串
     */
    public static String generateToken(Map<String, Object> claimsMap) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_MILLIS);

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claimsMap)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .compact();
    }

    /**
     * 解析并验证 JWT 令牌
     *
     * @param token 待解析的 JWT 字符串
     * @return 解析得到的 Claims（包含所有自定义数据和标准字段）
     * @throws io.jsonwebtoken.ExpiredJwtException      如果令牌已过期
     * @throws io.jsonwebtoken.SignatureException       如果签名不合法
     * @throws io.jsonwebtoken.MalformedJwtException    如果格式不正确
     * @throws io.jsonwebtoken.UnsupportedJwtException  如果不被支持
     * @throws IllegalArgumentException                 如果 token 为 null 或空串
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}