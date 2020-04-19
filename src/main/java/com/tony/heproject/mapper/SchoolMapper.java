package com.tony.heproject.mapper;
import com.tony.heproject.bean.School;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository
public interface SchoolMapper {

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
    int addSchool(School school);

    /**
     * 删除学校
     * @param id
     * @return
     */
    int deleteSchool(int id);
}

