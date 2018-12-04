package cn.lyf.staticresourceserver.service;

import cn.lyf.staticresourceserver.entity.UserEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author DIC.$user
 * @version V1.0
 * @Title: $file_name
 * @Package $package_name
 * @Description: $todo(用一句话描述该文件做什么)
 * @date $date$ $time
 */
@FeignClient(name = "user-server")
public interface UserService {
    /**
     * @method: login
     * @Param:  * @param userEntity
     * @Description: (用一句话描述该文件做什么)
     * @author: DIC.sweetlfy
     * @date: 2018/11/15 17:13
     * @Return: cn.lyf.oauthserver.entity.UserEntity
     * @version: V1.0
     */
    @RequestMapping(value = "/user/login",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    UserEntity login(@RequestParam("userName") String userName);
    /**
     * @method  register
     * @Param:  * @param userEntity
     * @Description: (用一句话描述该文件做什么)
     * @author DIC.sweetlfy
     * @date 2018/11/15 17:04
     * @Return int
     * @version V1.0
     */
    @PostMapping("/user/regist")
    int register(UserEntity userEntity);
    /**
     * @method: getAuthorities
     * @Param:  * @param username
     * @Description: (用一句话描述该文件做什么)
     * @author: DIC.sweetlfy
     * @date: 2018/11/15 17:19
     * @Return: java.util.List
     * @version: V1.0
     */
}
