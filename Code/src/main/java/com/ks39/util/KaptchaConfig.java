package com.ks39.util;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @Author: Ks-39
 * @Description: Kaptcha验证码生成Util
 * @Date: Create in 13:22 2020/3/4
 */
@Component
public class KaptchaConfig {
    //定义验证码为四个字
    private final static String CODE_LENGTH = "4";
    private final static String SESSION_KEY = "verification_session_key";

    @Bean
    public DefaultKaptcha defaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        //1. 设置边框
        properties.setProperty("kaptcha.border","no");
        //2. 设置边框颜色
        properties.setProperty("kaptcha.border.color","105,179,90");
        //3. 设置字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "orange");
        //4. 设置图片宽度
        properties.setProperty("kaptcha.image.width", "140");
        //5. 设置图片高度
        properties.setProperty("kaptcha.image.height", "50");
        //6. 设置字体尺寸
        properties.setProperty("kaptcha.textproducer.font.size", "40");
        //7. 设置图片样式
        properties.setProperty("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.ShadowGimpy");
        //8. 设置session key
        properties.setProperty("kaptcha.session.key", SESSION_KEY);
        //9. 设置验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", CODE_LENGTH);
        //10. 设置字体
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,黑体");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
