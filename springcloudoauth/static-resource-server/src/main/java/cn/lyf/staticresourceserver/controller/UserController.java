package cn.lyf.staticresourceserver.controller;

import cn.lyf.staticresourceserver.entity.UserEntity;
import cn.lyf.staticresourceserver.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @Title: UserController
 * @Package cn.lyf.staticresourceserver.controller
 * @Description: (用一句话描述该文件做什么)
 * @author DIC.sweetlfy
 * @date 2018/11/16 14:50 
 * @version V1.0
 */
@RestController
@PreAuthorize("hasAuthority('ddd')")
public class UserController {
    @Resource
    private UserService userServcie;

    @Value("${spring.mvc.static-path-pattern}")
    private String hello;
    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }
    /**
     * @method  regist
     * @Param:  * @param userName* @param password
     * @Description: (用一句话描述该文件做什么)
     * @author DIC.sweetlfy
     * @date 2018/11/15 15:43
     * @version V1.0
     */
    @PostMapping("/user/regist")
    public void regist(String userName,String password){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setPassword(new BCryptPasswordEncoder().encode(password));
        userServcie.register(userEntity);
    }
    @PostMapping("/user/login")
    public UserEntity login(String userName,String password){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity = userServcie.login(userName);
        return userEntity;
    }
}
