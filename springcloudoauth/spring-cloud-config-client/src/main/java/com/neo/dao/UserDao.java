package com.neo.dao;

import org.springframework.stereotype.Repository;

/**
 * @author DIC.lyf
 * @version V1.0
 * @Title: UserDao
 * @Package com.neo.web
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/12/5 15:00
 */
@Repository
public interface UserDao {
    String getpass(String user_name);
}
