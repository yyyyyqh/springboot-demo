package com.yqh.mp_post.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_info") // 告诉MP这个类对应数据库中的`user_info`表
public class User {
    // MP默认会把`id`字段当作主键
    private Long id;
    private String name;
    private Integer age;
    private String email;
}