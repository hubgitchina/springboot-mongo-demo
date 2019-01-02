package cn.com.my.service;

import java.util.List;

import cn.com.my.entity.UserEntity;
import cn.com.my.pojo.UserVo;

public interface UserServiceRepository {

	void saveUser(UserVo user);

	void updateUser(UserVo user);

	List<UserEntity> findByUserNameLike(String userName);

	List<UserEntity> findAll();
}
