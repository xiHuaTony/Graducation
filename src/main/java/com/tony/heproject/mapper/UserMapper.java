package com.tony.heproject.mapper;

import com.tony.heproject.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Mapper
@Repository
public interface UserMapper {

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

    User selectUserByAccount(String acu);
    /**
     * 增加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新用户
     * @param user
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    int deleteUser(int id);

    /**
     * 根据用户名判断用户角色
     * @param account
     * @return
     */
    @Select("  select r.rname from `user` u" +
            "  LEFT JOIN user_role ur on u.id=ur.uid " +
            "  LEFT JOIN role r on r.id=ur.rid " +
            "  where u.account=#{afdsafdsa}  ")
    Set<String> selectRnamesByAccount(String account);

    @Select(" select remark from role  ")
    Set<String> selectListRnamesByRole();
}

