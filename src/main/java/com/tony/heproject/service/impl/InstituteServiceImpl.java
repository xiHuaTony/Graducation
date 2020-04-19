package com.tony.heproject.service.impl;

import com.tony.heproject.bean.Institute;
import com.tony.heproject.mapper.InstituteMapper;
import com.tony.heproject.service.InstituteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstituteServiceImpl implements InstituteService {

    @Autowired
    private InstituteMapper instituteMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public List<Institute> selectAllInstitutes() {
        return instituteMapper.selectAllInstitutes();
    }


    /**
     * redis测试list类型
     * @param dname
     * @return
     */
//    @Override
//    public List<Institute> selectDevicesByName(String dname) {
//        if( redisTemplate.opsForList().size(KeyNameUtil.DEVICE)!=0){
//            log.info("redis中查询出来的数据======》");
//            System.out.println(redisTemplate.opsForList().range(KeyNameUtil.DEVICE, 0, -1));
//            return null;
//        }else{
//            log.info("MySQL中查询出来的数据======》");
//            List<Institute>  deviceList = deviceMapper.selectDevicesByName(dname);
//            redisTemplate.opsForList().rightPushAll(KeyNameUtil.DEVICE,deviceList);
//
//            return deviceList ;
//        }
//        return instituteMapper.selectDevicesByName(dname);
//
//    }





    @Override
    public void addInstitute(Institute institute) {
        instituteMapper.addInstitute(institute);
    }

    @Override
    public void deleteInstitute(int id) {
        instituteMapper.deleteInstitute(id);
    }

}
