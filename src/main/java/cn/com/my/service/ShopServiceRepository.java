package cn.com.my.service;

import java.util.List;

import cn.com.my.entity.ShopEntity;
import cn.com.my.pojo.ShopVo;

public interface ShopServiceRepository {

	void addShop(ShopVo shop);

	void updateShop(ShopVo shop);

	List<ShopEntity> findByShopNameLike(String ShopName);

	List<ShopEntity> findAll();

	void deleteShop(long id);
}
