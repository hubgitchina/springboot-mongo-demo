package cn.com.my.repository.primary;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.com.my.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, Long> {

	List<UserEntity> findByUserNameLike(String userName);
}
