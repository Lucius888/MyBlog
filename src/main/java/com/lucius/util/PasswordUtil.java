/**
 * Copyright (C), Lucius
 * FileName: PasswordUtil
 * Author:
 * Date:     2020/4/18 15:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lucius.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author Lucius
 */
public class PasswordUtil {
    /*
    使用shiro工具进行加密操作
    saltValue: 使用这个值产生盐
    password：加密前的密码
     */
    public static String shiroPasswordEncode(String saltValue,String password){
        ByteSource salt = ByteSource.Util.bytes(saltValue);
        String encodePassword = new SimpleHash("MD5", password, salt, 1024).toHex();
        return encodePassword;
    }

}
