package com.tony.heproject.configure;

import com.tony.heproject.shiro.FilterChainDefinitionMapBuild;
import com.tony.heproject.shiro.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname ShiroConfig
 * @Author Tony
 * @Description TODO
 * @Date 2020/2/10 9:47
 * @Created by Administrator
 */
@Configuration
public class ShiroConfig {
    /**
     * 加密算法
     * @return
     */
    @Bean
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(2);
        return credentialsMatcher;
    }

    /**
     * 自定义Realm类
     * @return
     */
    @Bean
    public ShiroRealm realm(){
        ShiroRealm realm=new ShiroRealm();
        realm.setCredentialsMatcher(credentialsMatcher());
        return realm;
    }

    /**
     * SecurityManager
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        return securityManager;
    }

    @Autowired
    private FilterChainDefinitionMapBuild mapBuild;
    /**
     * ShiroFilterChainDefinition
     *
     */
    @Bean
    public ShiroFilterChainDefinition filterChainDefinition(){
        DefaultShiroFilterChainDefinition filterChainDefinition=new DefaultShiroFilterChainDefinition();

        //工厂注入，将resources所有信息都入在进来
      filterChainDefinition.addPathDefinitions(mapBuild.build());
        return filterChainDefinition;
    }



}
