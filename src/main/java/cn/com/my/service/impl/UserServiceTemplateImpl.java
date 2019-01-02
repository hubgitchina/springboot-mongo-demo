package cn.com.my.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import cn.com.my.entity.UserEntity;
import cn.com.my.pojo.UserVo;
import cn.com.my.service.UserServiceTemplate;

@Service
public class UserServiceTemplateImpl implements UserServiceTemplate {

	// @Autowired
	// private MongoTemplate mongoTemplate;

	@Autowired
	@Qualifier(value = "primaryMongoTemplate")
	protected MongoTemplate primaryMongoTemplate;

	@Autowired
	@Qualifier(value = "secondaryMongoTemplate")
	protected MongoTemplate secondaryMongoTemplate;

	@Override
	public void saveUser(UserVo user) {

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		// save方法在新增文档时，如果有一个相同_ID的文档时，会覆盖原来的
		// mongoTemplate.save(userEntity);
		primaryMongoTemplate.save(userEntity);

		// 同时往另一个数据源插入数据
		secondaryMongoTemplate.save(userEntity);

		// insert方法在新增文档时，如果有一个相同的_ID时，就会新增失败，抛出异常
		// mongoTemplate.insert(userEntity);
	}

	@Override
	public void updateUser(UserVo user) {

		Query query = new Query(Criteria.where("id").is(user.getId()));
		Update update = new Update().set("userName", user.getUserName()).set("password",
				user.getPassword());
		// 更新查询返回结果集的第一条
		// mongoTemplate.updateFirst(query, update, UserEntity.class);
		primaryMongoTemplate.updateFirst(query, update, UserEntity.class);

		// 更新查询返回结果集的所有
		// mongoTemplate.updateMulti(query,update,UserEntity.class);
	}

	@Override
	public void deleteUser(long id) {

		Query query = new Query(Criteria.where("id").is(id));
		// mongoTemplate.remove(query, UserEntity.class);
		primaryMongoTemplate.remove(query, UserEntity.class);
	}

	@Override
	public List<UserEntity> findByUserNameLike(String userName) {

		Query query = new Query(Criteria.where("userName").regex(userName));
		// return mongoTemplate.find(query, UserEntity.class);
		return primaryMongoTemplate.find(query, UserEntity.class);
	}

	@Override
	public List<UserEntity> findAll() {

		// return mongoTemplate.findAll(UserEntity.class);
		return primaryMongoTemplate.findAll(UserEntity.class);
	}

	@Override
	public void createCollection(String collectionName) {

		// if (mongoTemplate.collectionExists(collectionName)) {
		// throw new RuntimeException("集合已存在");
		// }
		// mongoTemplate.createCollection(collectionName);

		if (primaryMongoTemplate.collectionExists(collectionName)) {
			throw new RuntimeException("集合已存在");
		}
		primaryMongoTemplate.createCollection(collectionName);
	}

	@Override
	public void saveMap(Map<String, Object> map) {

		String collectionName = (String) map.get("collectionName");
		map.remove("collectionName");
		// mongoTemplate.save(map, collectionName);
		primaryMongoTemplate.save(map, collectionName);
	}

	@Override
	public List<Map> findByChildParams(Map<String, Object> params) {

		String collectionName = (String) params.get("collectionName");
		params.remove("collectionName");
		Query query = new Query();
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			query.addCriteria(Criteria.where(entry.getKey()).is(entry.getValue()));
		}

		// return mongoTemplate.find(query, Map.class, collectionName);
		return primaryMongoTemplate.find(query, Map.class, collectionName);
	}
}
