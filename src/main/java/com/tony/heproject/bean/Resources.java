package com.tony.heproject.bean;
import lombok.Data;

import java.io.Serializable;

/**
 序列化：将对象转换成字节序列的过程 称为序列化
 反序列化：将字节序列恢复成对象的过程  称为反序列化
 */
@Data
public class Resources implements Serializable {
    private Integer id;

    private String keyurl;

    private String filtername;

    private Integer sortnum;

}