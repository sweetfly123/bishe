package cn.lyf.oauthserver.controller;

import cn.lyf.oauthserver.entity.UserEntity;
import cn.lyf.oauthserver.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @Title: UserController
 * @Package cn.lyf.oauthserver.controller
 * @Description: (用一句话描述该文件做什么)
 * @author DIC.sweetlfy
 * @date 2018/11/14 14:43
 * @version V1.0
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;
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
        userService.register(userEntity);
    }
    @PostMapping("/user/login")
    public UserEntity login(String userName){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        return userService.login(userEntity);

    }
}
