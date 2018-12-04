package cn.lyf.userserver.controller;

import cn.lyf.userserver.entity.UserEntity;
import cn.lyf.userserver.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public UserEntity login(@RequestParam("userName") String userName){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity = userService.login(userEntity);
        return userEntity;

    }
}
