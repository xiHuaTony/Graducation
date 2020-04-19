package com.tony.heproject.service.impl;
import com.tony.heproject.bean.Resources;
import com.tony.heproject.mapper.ResourcesMapper;
import com.tony.heproject.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ResourcesServiceImpl
 * @Author guoweixin
 * @Description TODO
 * @Date 2019/10/24 11:33
 * @Created by Administrator
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {
    @Autowired
    private ResourcesMapper resourcesMapper;
            ;
    @Override
    public List<Resources> selectListBySortNum() {
        return resourcesMapper.selectListBySortNum();
    }
}
