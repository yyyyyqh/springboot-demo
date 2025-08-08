package com.yqh.mp_post.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yqh.mp_post.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 告诉Spring这是个Mapper Bean
public interface UserMapper extends BaseMapper<User> {
    // 继承了BaseMapper后，就自动拥有了增、删、改、查等一系列方法
}