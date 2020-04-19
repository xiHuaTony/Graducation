package com.tony.heproject.service;

import com.tony.heproject.bean.Institute;

import java.util.List;

public interface InstituteService {
    /**
     * 查询所有学院
     * @return
     */
    List<Institute> selectAllInstitutes();


    /**
     * 增加学院
     * @param institute
     * @return
     */
    void addInstitute(Institute institute);
    /**
     * 删除学院
     * @param id
     * @return
     */
    void deleteInstitute(int id);
}
