package com.ks39.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ks39.entity.Permission;
import com.ks39.entity.Role;
import com.ks39.entity.User;
import com.ks39.service.PermissionService;
import com.ks39.util.PageResultBean;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Description: Permission页面Controller
 * @Date: Create in 13:14 2020/3/13
 */
@Controller
public class PermissionController {

    private Map<String,Object> result = new HashMap<>();

    @Resource
    private PermissionService permissionService;

    //0. CheckPermissionName
    @RequestMapping("/permission/checkPermissionname")
    @ResponseBody
    public Map<String,Object> checkPermissionname(Permission permission) {
        //isEmpty()判断list是否为空
        if(!permissionService.PermissionGetList(permission).isEmpty()) {
            result.put("success", false);
        }else {
            result.put("success",true);
        }
        return result;
    }

    //1. GetList/Search
    //1.1 getList页面
    @RequestMapping("/permission/info")
    public String permissionInfo(){
        return "views/permission/info";
    }

    //1.2 getinfo
    @RequestMapping("/permission/getinfo")
    @ResponseBody
    public PageResultBean<Permission> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                              @RequestParam(value = "limit", defaultValue = "10") int limit,
                                              Permission permission) {
        PageHelper.startPage(page,limit);
        List<Permission> permissions  = permissionService.PermissionGetList(permission);
        PageInfo<Permission> permissionPageInfo  = new PageInfo<>(permissions);
        return new PageResultBean<>(permissionPageInfo.getTotal(), permissionPageInfo.getList());
    }

    //2. add
    //2.1 add页面
    @RequestMapping("/permission/add")
    public String permisssionAdd(){
        return "views/permission/add";
    }

    //2.2 doAdd操作
    @RequestMapping("/permission/doAdd")
    @ResponseBody
    public Map<String,Object> doAdd(Permission permission){
        if(permissionService.PermissionAdd(permission) > 0){
            result.put("success",true);
        }else{
            result.put("success",false);
        }
        return result;
    }


    //3. edit
    //3.1 edit页面（先通过pid获取需要修改的数据，回显到表单中）（@PathVariable获取url的pid参数）
    @RequestMapping("/permission/edit/{pid}")
    public String userEdit(@PathVariable("pid") Integer pid, Model model) {
        Permission permission = new Permission(pid);
        //1. 回显permission
        model.addAttribute("permission",permissionService.PermissionGetList(permission));
        return "views/permission/edit";
    }

    //3.2 doEdit操作
    @RequestMapping("/permission/doEdit")
    @ResponseBody
    public Map<String,Object> doEdit(Permission permission){
        if(permissionService.PermissionEdit(permission) > 0 ){
            result.put("success",true);
        }else {
            result.put("success",false);
        }
        return result;
    }

    //4. delete
    //根据pid删除（@PathVariable获取url的pid参数）
    @RequestMapping("/permission/delete/{pid}")
    @ResponseBody
    public Map<String,Object> delete(@PathVariable("pid") Integer pid){
        if(permissionService.PermissionDelete(pid) == true){
            result.put("success",true);
        }else {
            result.put("success",false);
        }
        return result;
    }
}
