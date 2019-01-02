package cn.com.my.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.util.StringUtils;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import lombok.Getter;
import lombok.Setter;

/**
 * 根据配置文件创建MongoDbFactory
 * 
 * @author wangpeng1
 * @since 2018年12月29日
 */
@Getter
@Setter
public abstract class AbstractMongoConfig {

	// MongoDB Properties
	private String hostPort, database, username, password;

	public MongoDbFactory mongoDbFactory() throws Exception {

		List<ServerAddress> seeds = new ArrayList<>();
		String[] hostPorts = hostPort.split(",");
		for (int i = 0; i < hostPorts.length; i++) {
			String[] hps = hostPorts[i].split(":");
			ServerAddress serverAddress = new ServerAddress(hps[0], Integer.valueOf(hps[1]));
			seeds.add(serverAddress);
		}
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return new SimpleMongoDbFactory(new MongoClient(seeds), database);
		}

		List<MongoCredential> mongoCredentialList = new ArrayList<>();
		mongoCredentialList
				.add(MongoCredential.createCredential(username, database, password.toCharArray()));
		return new SimpleMongoDbFactory(new MongoClient(seeds, mongoCredentialList), database);
	}

	abstract public MongoTemplate getMongoTemplate() throws Exception;
}
