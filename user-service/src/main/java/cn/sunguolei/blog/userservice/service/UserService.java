package cn.sunguolei.blog.userservice.service;

import cn.sunguolei.blog.userservice.domain.User;

public interface UserService {

    User findUserByUsername(String username);

}
