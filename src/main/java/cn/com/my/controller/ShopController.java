package cn.com.my.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.my.entity.ShopEntity;
import cn.com.my.pojo.ShopVo;
import cn.com.my.service.ShopServiceRepository;

@RestController
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ShopServiceRepository shopServiceRepository;

	@PostMapping("/addShop")
	public String addShop(@RequestBody @Valid ShopVo shopVo) {

		shopServiceRepository.addShop(shopVo);

		return "success";
	}

	@PostMapping("/updateShop")
	public String updateShop(@RequestBody @Valid ShopVo shopVo) {

		shopServiceRepository.updateShop(shopVo);

		return "success";
	}

	@GetMapping("/deleteShop")
	public String deleteShop(@RequestParam long id) {

		shopServiceRepository.deleteShop(id);

		return "success";
	}

	@GetMapping("/findByShopNameLike")
	public List<ShopEntity> findByShopNameLike(@RequestParam String shopName) {

		return shopServiceRepository.findByShopNameLike(shopName);
	}

	@GetMapping("/findAll")
	public List<ShopEntity> findAll() {

		return shopServiceRepository.findAll();
	}
}
