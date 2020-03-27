package com.ks39.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ks39.entity.Role;
import com.ks39.entity.User;
import com.ks39.service.RoleService;
import com.ks39.service.UserService;
import com.ks39.util.PageResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ks-39
 * @Description: User页面Controller
 * @Date: Create in 9:06 2020/3/11
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    private Map<String,Object> result = new HashMap<>();

    //0. checkUsername
    @RequestMapping("/user/checkUsername")
    @ResponseBody
    public Map<String,Object> checkUsername(User user) {
        if(!userService.UserGetList(user).isEmpty()) {
            result.put("success", false);
        }else {
            result.put("success",true);
        }
        return result;
    }

    //1. getList/Search
    //1.1 userinfo页面
    @RequestMapping("/user/info")
    public String userInfo(){
        return "/views/user/info";
    }

    //1.2 getList/Search操作
    @RequestMapping("/user/getinfo")
    @ResponseBody
    public PageResultBean<User> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                        @RequestParam(value = "limit", defaultValue = "10") int limit,
                                        User user) {
        PageHelper.startPage(page,limit);
        List<User> users = userService.UserGetList(user);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return new PageResultBean<>(userPageInfo.getTotal(), userPageInfo.getList());
    }

    //2. add
    //2.1 add页面
    @RequestMapping("/user/add")
    public String userAdd(Model model, Role role){
        //1. 回显role角色选项
        model.addAttribute("roles", roleService.RoleGetList(role));
        return "views/user/add";
    }

    //2.2 执行add
    @RequestMapping("/user/doAdd")
    @ResponseBody
    public Map<String,Object> doAdd(User user){
        if(userService.UserAdd(user) > 0){
            result.put("success",true);
        }else{
            result.put("success",false);
        }
        return result;
    }

    //3. edit
    //3.1 先通过userid获取需要修改的数据，回显到表单中
    @RequestMapping("/user/edit/{userid}")
    public String userEdit(@PathVariable("userid") Integer userid,Model model,Role role) {
        User user = new User(userid);
        //1. 回显user数据
        model.addAttribute("user",userService.UserGetList(user));
        //2. 回显role角色选项
        model.addAttribute("roles", roleService.RoleGetList(role));
        return "views/user/edit";
    }

    //3.2 doEdit
    @RequestMapping("/user/doEdit")
    @ResponseBody
    public Map<String,Object> doEdit(User user){
        if(userService.UserEdit(user) > 0){
            result.put("success",true);
        }else {
            result.put("success",false);
        }
        return result;
    }

    //4. delete
    //根据userid删除
    @RequestMapping("/user/delete/{userid}")
    @ResponseBody
    public Map<String,Object> delete(@PathVariable("userid") Integer userid){
        User user = new User(userid);
        if(userService.UserDelete(user) > 0){
            result.put("success",true);
        }else {
            result.put("success",false);
        }
        return result;
    }
}
