package cn.com.my.pojo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo implements Serializable {

	private static final long serialVersionUID = -5842287230088109650L;

	private Long id;

	@NotBlank(message = "用户名称不能为空")
	private String userName;

	@NotBlank(message = "用户密码不能为空")
	private String password;
}
