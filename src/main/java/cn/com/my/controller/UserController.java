package cn.com.my.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.my.entity.UserEntity;
import cn.com.my.pojo.UserVo;
import cn.com.my.service.UserServiceRepository;
import cn.com.my.service.UserServiceTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceRepository userServiceRepository;

	@Autowired
	private UserServiceTemplate userServiceTemplate;

	@PostMapping("/addUser")
	public String addUser(@RequestBody @Valid UserVo user) {

		userServiceRepository.saveUser(user);

		return "success";
	}

	@PostMapping("/updateUser")
	public String updateUser(@RequestBody @Valid UserVo user) {

		userServiceTemplate.updateUser(user);

		return "success";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam long id) {

		userServiceTemplate.deleteUser(id);

		return "success";
	}

	@GetMapping("/findByUserNameLike")
	public List<UserEntity> findByUserNameLike(@RequestParam String userName) {

		return userServiceTemplate.findByUserNameLike(userName);
	}

	@GetMapping("/findAll")
	public List<UserEntity> findAll() {

		return userServiceTemplate.findAll();
	}

	@GetMapping("/createCollection")
	public String createCollection(@RequestParam String collectionName) {

		userServiceTemplate.createCollection(collectionName);

		return "success";
	}

	@PostMapping("/saveMap")
	public String saveMap(@RequestBody Map<String, Object> map) {

		userServiceTemplate.saveMap(map);

		return "success";
	}

	@PostMapping("/findByChildParams")
	public List<Map> findByChildParams(@RequestBody Map<String, Object> map) {

		return userServiceTemplate.findByChildParams(map);
	}
}
