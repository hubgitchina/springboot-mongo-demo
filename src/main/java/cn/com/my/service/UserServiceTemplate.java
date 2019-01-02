package cn.com.my.service;

import java.util.List;
import java.util.Map;

import cn.com.my.entity.UserEntity;
import cn.com.my.pojo.UserVo;

public interface UserServiceTemplate {

	void saveUser(UserVo user);

	void updateUser(UserVo user);

	void deleteUser(long id);

	List<UserEntity> findByUserNameLike(String userName);

	List<UserEntity> findAll();

	void createCollection(String collectionName);

	void saveMap(Map<String, Object> map);

	List<Map> findByChildParams(Map<String, Object> params);

}
