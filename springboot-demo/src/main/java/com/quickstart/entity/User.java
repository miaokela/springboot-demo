package com.quickstart.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("`user`") // 表注解
public class User {
    @TableId(type = IdType.AUTO)  // 主键注解
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
