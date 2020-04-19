package com.tony.heproject.service;

import com.tony.heproject.bean.School;
import java.util.List;


public interface SchoolService {
    /**
     * 查询所有学校
     * @return
     */
    List<School> selectAllSchools();


    /**
     * 增加学校
     * @param school
     * @return
     */
    void addSchool(School school);
    /**
     * 删除学校
     * @param id
     * @return
     */
    void deleteSchool(int id);
}
