package com.ks39.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ks39.entity.Permission;
import com.ks39.entity.Role;
import com.ks39.service.PermissionService;
import com.ks39.service.RoleService;
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
 * @Description: Role页面Controller
 * @Date: Create in 13:03 2020/3/13
 */
@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    private Map<String,Object> result = new HashMap<>();

    //0. checkRolename
    @RequestMapping("/role/checkRolename")
    @ResponseBody
    public Map<String,Object> checkRolename(Role role) {
        if(!roleService.RoleGetList(role).isEmpty()) {
            result.put("success", false);
        }else {
            result.put("success",true);
        }
        return result;
    }

    @RequestMapping("/role/info")
    public String roleInfo(){
        return "views/role/info";
    }

    @RequestMapping("/role/getinfo")
    @ResponseBody
    public PageResultBean<Role> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                        @RequestParam(value = "limit", defaultValue = "10") int limit,
                                        Role role) {
        PageHelper.startPage(page,limit);
        List<Role> roles = roleService.RoleGetList(role);
        PageInfo<Role> rolePageInfo  = new PageInfo<>(roles);
        return new PageResultBean<>(rolePageInfo.getTotal(), rolePageInfo.getList());
    }

    //2. add
    //2.1 add页面
    @RequestMapping("/role/add")
    public String roleAdd(Model model, Permission permission){
        //回显permissions数据
        model.addAttribute("permissions",permissionService.PermissionGetList(permission));
        return "views/role/add";
    }

    //2.2 doAdd
    @RequestMapping("/role/doAdd")
    @ResponseBody
    public Map<String,Object> doAdd(Role role, @RequestParam(value = "pids[]", required = false) Integer[] pids){
        if(roleService.RoleAdd(role,pids) == true){
            result.put("success",true);
        }else{
            result.put("success",false);
        }
        return result;
    }

    //3. edit
    //3.1 先通过roleid获取需要修改的数据，回显到表单中（@PathVaribable获取url的rid参数）
    @RequestMapping("/role/edit/{rid}")
    public String userEdit(@PathVariable("rid") Integer rid, Model model, Permission permission) {
        Role role = new Role(rid);
        //1. 回显role信息
        model.addAttribute("role",roleService.RoleGetList(role));
        //2. 回显permission选项信息
        model.addAttribute("permissions",permissionService.PermissionGetList(permission));
        return "views/role/edit";
    }

    //3.2 doEdit
    @RequestMapping("/role/doEdit")
    @ResponseBody
    public Map<String,Object> doEdit(Role role, @RequestParam(value = "pids[]", required = false) Integer[] pids){
        if(roleService.RoleEdit(role,pids) == true){
            result.put("success",true);
        }else {
            result.put("success",false);
        }
        return result;
    }

    //4. delete
    @RequestMapping("/role/delete/{rid}")
    @ResponseBody
    public Map<String,Object> delete(@PathVariable("rid") Integer rid){
        if(roleService.RoleDelete(rid) == true){
            result.put("success",true);
        }else {
            result.put("success",false);
        }
        return result;
    }
}
