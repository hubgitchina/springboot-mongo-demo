package cn.com.my.repository.secondary;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.com.my.entity.ShopEntity;

public interface ShopRepository extends MongoRepository<ShopEntity, String> {

	List<ShopEntity> findByShopNameLike(String shopName);
}
