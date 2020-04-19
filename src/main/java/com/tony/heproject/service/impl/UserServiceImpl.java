package com.tony.heproject.service.impl;

import com.tony.heproject.bean.User;
import com.tony.heproject.mapper.UserMapper;
import com.tony.heproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public User selectUserById(int id ) {
        return userMapper.selectUserById(id);
    }

    @Override
    public User selectUserByAccount(String act) {
        return  userMapper.selectUserByAccount(act);
    }

    /**
     * 根据用户名 查询所有的角色名称（信息）
     *
     * @param act 用户名
     * @return
     */
    @Override
    public Set<String> selectRnamesByAccount(String act) {
        return userMapper.selectRnamesByAccount(act);
    }

    /**
     * 查询所有的角色
     *
     * @return
     */
    @Override
    public Set<String> selectListRnamesByRole() {
        return userMapper.selectListRnamesByRole();
}

    @Override
    public void addUser(User user) {

        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}
