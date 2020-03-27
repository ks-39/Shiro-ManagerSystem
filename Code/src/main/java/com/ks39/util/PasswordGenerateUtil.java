package com.ks39.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Author: Ks-39
 * @Description: Md5加密Util
 * @Date: Create in 12:44 2020/3/13
 */

public class PasswordGenerateUtil {
    public static String getPassword(String username,String password,int hashTimes){
        String Md5Password = new Md5Hash(password,username,hashTimes).toHex();
        return Md5Password;
    }
}
