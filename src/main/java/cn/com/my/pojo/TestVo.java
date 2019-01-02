package cn.com.my.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestVo implements Serializable {

	private static final long serialVersionUID = -5842287230088109650L;

	@Id
	private Long id;

	private String name;
}
