package cn.sunguolei.blog.userservice.mapper;


import cn.sunguolei.blog.userservice.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findUserByUsername(String username);

}
