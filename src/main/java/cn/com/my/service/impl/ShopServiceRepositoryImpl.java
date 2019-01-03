package cn.com.my.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.my.entity.ShopEntity;
import cn.com.my.pojo.ShopVo;
import cn.com.my.repository.secondary.ShopRepository;
import cn.com.my.service.ShopServiceRepository;

@Service
public class ShopServiceRepositoryImpl implements ShopServiceRepository {

	@Autowired
	private ShopRepository shopRepository;

	@Override
	public void addShop(ShopVo shop) {

		ShopEntity shopEntity = new ShopEntity();
		BeanUtils.copyProperties(shop, shopEntity);
		shopRepository.save(shopEntity);
	}

	@Override
	public void updateShop(ShopVo shop) {

		ShopEntity shopEntity = new ShopEntity();
		BeanUtils.copyProperties(shop, shopEntity);
		shopRepository.save(shopEntity);
	}

	@Override
	public List<ShopEntity> findByShopNameLike(String shopName) {

		return shopRepository.findByShopNameLike(shopName);
	}

	@Override
	public List<ShopEntity> findAll() {

		return shopRepository.findAll();
	}

	@Override
	public void deleteShop(long id) {

		shopRepository.delete(id);
	}
}
