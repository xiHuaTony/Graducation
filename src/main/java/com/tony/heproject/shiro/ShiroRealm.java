package com.tony.heproject.shiro;
import com.tony.heproject.bean.User;
import com.tony.heproject.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * @Classname ShiroRealm
 * @Author guoweixin
 * @Description TODO
 * @Date 2019/10/22 14:25
 * @Created by Administrator
 */
/**
 * Shiro 从 Realm 获取安全数据（如用户、角色、权限）
 */

@Controller
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1 得到用户名
        UsernamePasswordToken upToken= (UsernamePasswordToken) token;
        // upToken.getPassword(); 前端输入的密码
        String account=upToken.getUsername();
        // 2根据用户名查询数据库 是否存在
        User user = userService.selectUserByAccount(account);
        if(user==null){
            throw  new UnknownAccountException("用户名不存在");
        }

        /**
        身份验证: principals 和 credentials 组合就是用户名/密码.
         */
        Object principal=account;
        // 数据库查询出的密码
        Object credentials = user.getPwd();
        //realm名称
        String realmName=super.getName();
        //实现的方式是将每一个口令同一个叫做”盐“（salt）的n位随机数相关联。
        ByteSource salt=ByteSource.Util.bytes(account);
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal,credentials,salt,realmName);
        return info;
    }

    /**
     * 授权方法
     1、该方法什么时候会被调用？
     当访问某个资源 被 Roles[] 过滤器。
     2、方法的入参是什么？
     主体唯一标识
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1 得到当前主体的用户名
        String account= (String) principals.getPrimaryPrincipal();
        //2 根据用户名 查询访用户拥有哪些角色
        Set<String> roles = userService.selectRnamesByAccount(account);
        //3 如果某个用户角色里面，只要包含了高级职称角色。那么所有的角色该用户都具备。
        if(roles.contains("admin")){
            //查询所有的角色，赋给该用户
            roles=userService.selectListRnamesByRole();
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo(roles);
        return info;
    }

    /**
     * 此处只是提取加密后的字符串
     * 实际开发的时候  要去掉这部分代码
     * @param args
     */
    public static void main(String[] args) {
        /**  注册 时 ，完成密码的加密
         * param1  hashAlgorithmName 加密的名称
         * param2  credentials要加密字符串
         * param4 hashIterations 加密的次数
         */
        String hashAlgorithmName="MD5";
        //注册的密码
        Object credentials="yxr123";
        int hashIterations=2;
        String uname="Rabbit";
        ByteSource salt=ByteSource.Util.bytes(uname);

        Object obj=  new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(obj);
        /*
         未加盐： e512078030c4b482bee6366ed51c6521
             admin :  360cb1ef0a5aefc57c4ba03f6e903933
             lisi  :  14578254792fe22981f8f925f2b85bf6

         */
    }



}
