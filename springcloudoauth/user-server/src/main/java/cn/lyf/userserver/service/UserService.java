package cn.lyf.userserver.service;


import cn.lyf.userserver.entity.UserEntity;

import java.util.List;

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
    UserEntity login(UserEntity userEntity);
    /**
     * @method  register
     * @Param:  * @param userEntity
     * @Description: (用一句话描述该文件做什么)
     * @author DIC.sweetlfy
     * @date 2018/11/15 17:04
     * @Return int
     * @version V1.0
     */
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
    List<String> getAuthorities(String userName);
}
