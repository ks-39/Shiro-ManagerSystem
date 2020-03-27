package com.ks39.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.ks39.entity.User;
import com.ks39.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


/**
 * @Author: Ks-39
 * @Description: Login、index页面Controller
 * @Date: Create in 1:04 2020/3/11
 */
@Controller
public class IndexController {

    @RequestMapping("/login")
    public String Login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        //1. 清除session
        request.getSession().invalidate();
        //2. token退出
        SecurityUtils.getSubject().logout();
        return "login";
    }

    @RequestMapping("/index")
    public String Index(){
        return "index";
    }

    private String SHIRO_VERIFY_SESSION = "verifySessionCode";

    @Autowired
    private UserService userService;

    @RequestMapping("/checkLogin")
    public String CheckLogin(User user,Model model,String verifyCode){
        //1. 获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2. 获取session的验证码
        Object verCode = subject.getSession().getAttribute(SHIRO_VERIFY_SESSION);
        //3. 校验验证码
        if("".equals(verifyCode)||(!verCode.equals(verifyCode))){
            model.addAttribute("LoginMsg","验证码错误");
            return "/login";
        }
        //4. 封装前端数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        //5. 执行login方法
        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            model.addAttribute("LoginMsg","用户名错误");
        }catch (IncorrectCredentialsException e){
            model.addAttribute("LoginMsg","密码错误");
        }

        //6. 判断login结果
        if(subject.isAuthenticated()){
            //更新lastlogintime
            userService.UserUpdateLastLoginTime(user.getUsername());
            return "redirect:/index";
        }else {
            token.clear();
            return "/login";
        }
    }

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @RequestMapping("/getCode")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        byte[] verByte = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute(SHIRO_VERIFY_SESSION,createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge,"jpg",jpegOutputStream);
        } catch (IllegalArgumentException e){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IOException e){
            e.printStackTrace();
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        verByte = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(verByte);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @RequestMapping("/projectInfo")
    public String Projectinfo(){
        return "projectInfo";
    }

    @RequestMapping("/main")
    public String Main(){
        return "main";
    }

    @RequestMapping("/setting")
    public String Setting(){
        return "setting";
    }
}
