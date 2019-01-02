package cn.com.my.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.my.entity.UserEntity;
import cn.com.my.pojo.UserVo;
import cn.com.my.repository.primary.UserRepository;
import cn.com.my.service.UserServiceRepository;

@Service
public class UserServiceRepositoryImpl implements UserServiceRepository {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(UserVo user) {

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		userRepository.save(userEntity);
	}

	@Override
	public void updateUser(UserVo user) {

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		userRepository.save(userEntity);
	}

	@Override
	public List<UserEntity> findByUserNameLike(String userName) {

		return userRepository.findByUserNameLike(userName);
	}

	@Override
	public List<UserEntity> findAll() {

		return userRepository.findAll();
	}
}
