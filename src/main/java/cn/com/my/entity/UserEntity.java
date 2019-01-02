package cn.com.my.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "user")
public class UserEntity {

	@Id
	private long id;

	@Field("userName")
	private String userName;

	@Field("password")
	private String password;
}
