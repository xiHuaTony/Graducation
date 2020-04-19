package com.tony.heproject.mapper;

import com.tony.heproject.bean.Institute;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InstituteMapper {

    /**
     * 查询所有学院
     * @return
     */
    List<Institute> selectAllInstitutes();



    /**
     * 增加设备
     * @param institute
     * @return
     */
    int addInstitute(Institute institute);

    /**
     * 删除学院
     * @param id
     * @return
     */
    int deleteInstitute(int id);


}

