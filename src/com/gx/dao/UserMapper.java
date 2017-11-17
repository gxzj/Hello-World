package com.gx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gx.po.User;
import com.gx.vo.UserVo;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    public List<UserVo> findUserVoAll();
    
    public User findByUsername(@Param("username") String username);
    
    public User findByUsernameVo(@Param("vo") User user);
}