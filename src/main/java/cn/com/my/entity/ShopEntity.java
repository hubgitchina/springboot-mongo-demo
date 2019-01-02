package cn.com.my.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "shop")
public class ShopEntity {

	@Id
	private long id;

	@Field("name")
	private String shopName;
}
