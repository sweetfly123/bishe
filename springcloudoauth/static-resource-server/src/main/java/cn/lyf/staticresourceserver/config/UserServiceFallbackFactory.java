/*
package cn.lyf.staticresourceserver.config;

import cn.lyf.staticresourceserver.entity.UserDO;
import cn.lyf.staticresourceserver.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

*/
/**
 * @author DIC.lyf
 * @version V1.0
 * @Title: UserServiceFallbackFactory
 * @Package cn.lyf.staticresourceserver.config
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/12/7 14:11
 *//*

@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public UserDO login(String userName) {
                UserDO userDO = new UserDO();
                userDO.setUserName("error");
                userDO.setPassword("error");
                return userDO;
            }
            @Override
            public int register(UserDO userDO) {
                return -1;
            }
        };
    }
}
*/
