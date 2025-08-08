package com.yqh.mp_post.controller;


import com.yqh.mp_post.entity.User;
import com.yqh.mp_post.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // 所有请求的基础路径是 /users
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // 1. 查询所有用户
    @GetMapping
    public List<User> listAll() {
        return userMapper.selectList(null); // 传入null表示无条件查询
    }

    // 2. 根据ID查询用户
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userMapper.selectById(id);
    }

    // 3. 新增用户
    @PostMapping
    public String addUser(@RequestBody User user) {
        int rows = userMapper.insert(user);
        return rows > 0 ? "新增成功！" : "新增失败！";
    }

    // 4. 更新用户
    @PutMapping
    public String updateUser(@RequestBody User user) {
        // MP会根据user对象里的id去更新记录
        int rows = userMapper.updateById(user);
        return rows > 0 ? "更新成功！" : "更新失败！";
    }

    // 5. 根据ID删除用户
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        int rows = userMapper.deleteById(id);
        return rows > 0 ? "删除成功！" : "删除失败！";
    }
}