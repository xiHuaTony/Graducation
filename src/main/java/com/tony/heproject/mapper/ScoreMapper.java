package com.tony.heproject.mapper;

import com.tony.heproject.bean.Course;
import com.tony.heproject.bean.score_look;
import com.tony.heproject.bean.user_course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScoreMapper {

    /**
     * 查询有成绩的学生
     */
    List<user_course> getScores(String teacher);


    /**
     * 查询无成绩的学生
     */

    List<user_course> setScores(String teacher);

    /**
     * 分数统计
     * @return
     */
    List<score_look>  scoresLook(String teacher);
    /**
     * 分数操作
     * @return
     */
    int scoreToSet(Integer account,Integer courseNum,Integer score);

}
