package cn.com.my.pojo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopVo implements Serializable {

	private static final long serialVersionUID = -5268402740753059631L;

	private Long id;

	@NotBlank(message = "店铺名称不能为空")
	private String shopName;
}
