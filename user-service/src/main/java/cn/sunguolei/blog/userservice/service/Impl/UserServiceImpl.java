package cn.sunguolei.blog.userservice.service.Impl;

import cn.sunguolei.blog.userservice.domain.User;
import cn.sunguolei.blog.userservice.mapper.UserMapper;
import cn.sunguolei.blog.userservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}
