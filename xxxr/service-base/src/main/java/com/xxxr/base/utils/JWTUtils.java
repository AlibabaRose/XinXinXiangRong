package com.xxxr.base.utils;

import com.xxxr.common.exception.BusinessException;
import com.xxxr.common.result.ResponseEnum;
import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;


/**
 * 令牌工具类
 */
public class JWTUtils {

    //令牌的有效时间是一天
    private static long tokenExpiration=1000*60*60*24;
    //令牌签名
    private static String tokenSignKey="#DW$RFE%*&";

    /**
     * 对签名进行再一次的白虎
     * @return
     */
    private static Key getKeyInstance(){
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
        //对原始签名进行处理
        byte[] bytes = DatatypeConverter.parseBase64Binary(tokenSignKey);
        return new SecretKeySpec(bytes,algorithm.getJcaName());
    }

    public static String createToken(Long userId,String username){
        String token= Jwts.builder()
                //设置主题
                .setSubject("XXXR-USER")
                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis()+tokenExpiration))
                .claim("username",username)
                .claim("userId",userId)
                //密钥加密
                .signWith(SignatureAlgorithm.HS512,getKeyInstance())
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }
    public static boolean checkToken(String token){
        if(StringUtils.isEmpty(token)) {
            return false;
        }
        try {
            Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Long getUserId(String token){
        Claims claim=getClaim(token);
        Integer userId = (Integer) claim.get("userId");
        return userId.longValue();
    }

    public static String getUsername(String token){
        Claims claim = getClaim(token);
        String username = (String) claim.get("username");
        return  username;
    }
    private static Claims getClaim(String token) {
        System.out.println(token);
        if(StringUtils.isEmpty(token)){
            throw new BusinessException(ResponseEnum.LOGIN_AUTH_ERROR);
        }else{
            try{
                //解析token，解析失败报异常
                Jws<Claims> claimsJws = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(token);
                Claims claims = claimsJws.getBody();
                return claims;
            }catch (Exception e){
                throw new BusinessException(ResponseEnum.LOGIN_AUTH_ERROR);
            }
        }
    }
}
