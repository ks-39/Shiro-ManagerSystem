package com.ks39.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Ks-39
 * @Description: Shiro配置类(添加@Bean注解交由spring管理)
 * @Date: Create in 19:30 2020/3/22
 */
@Configuration
public class ShiroConfig {

        //1. 注入CustomRealm
        @Bean
        public CustomRealm getCustomRealm(){
            CustomRealm customRealm = new CustomRealm();
            //1. Md5加密
            customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
            return customRealm;
        }


    //2. 创建DefaultWebSecurityManager安全管理器
    @Bean
    public DefaultWebSecurityManager getSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //1. 自定义缓存实现 使用redis
        securityManager.setCacheManager(cacheManager());
        //2.  关联CustomRealm（这一步必须放在最后，不然会不执行授权操作）
        securityManager.setRealm(getCustomRealm());
        return securityManager;
    }

    //3. 创建ShiroFilterFactoryBean拦截器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(getSecurityManager());
        /*
        anon:无需认证
        authc:认证
        user:rememberMe功能
         */
        //配置权限
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
        filterMap.put("/login","anon");
        filterMap.put("/checkLogin","anon");
        filterMap.put("/logout", "logout");
        filterMap.put("/getCode","anon");
        filterMap.put("../images/**","anon");
        filterMap.put("*.css", "anon");
        filterMap.put("*.js", "anon");
        filterMap.put("*.jpg", "anon");

        //这一步必须放在最后
        filterMap.put("/*","authc");

        //设置登录页面
        bean.setLoginUrl("/login");
        //设置未授权页面
        bean.setUnauthorizedUrl("/exception/403");
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    //4. 比较器:比较用户登录时输入的密码,跟数据库密码配合盐值salt解密后是否一致
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5"); //散列算法
        hashedCredentialsMatcher.setHashIterations(4); //散列的次数
        return hashedCredentialsMatcher;
    }

    //5. thymeleaf使用shiro标签
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    //6. redis管理器
    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("127.0.0.1");
        redisManager.setPort(6379);
        // 配置过期时间
        redisManager.setExpire(1800);
        redisManager.setTimeout(0);
        return redisManager;
    }

    //7. redis缓存管理器
    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        //1. 将redis缓存管理器交由redis管理器管理
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }
}
