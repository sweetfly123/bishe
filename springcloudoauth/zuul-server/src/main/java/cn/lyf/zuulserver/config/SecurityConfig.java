package cn.lyf.zuulserver.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * @Title: SecurityConfig
 * @Package cn.lyf.zuulserver.config
 * @Description: 请求拦截配置
 * @author DIC.sweetlfy
 * @date 2018/11/14 14:30
 * @version V1.0
 */

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }


}
