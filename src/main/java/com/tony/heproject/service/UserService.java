package com.tony.heproject.service;

import com.tony.heproject.bean.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUsers();

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    User selectUserById(int id);

    User selectUserByAccount(String act);

    /**
     * 根据用户名查询所有的角色名称（信息）
     * @param act 用户名
     * @return
     */
    Set<String> selectRnamesByAccount(String act);

    /**
     * 查询所有的角色
     * @return
     */
    Set<String> selectListRnamesByRole();
    /**
     * 增加用户
     * @param user
     * @return
     */
    void addUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void  updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(int id);


}
