package cn.com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
public class MongoDBApplication {

	public static void main(String[] args) {

		SpringApplication.run(MongoDBApplication.class, args);
		// new
		// SpringApplicationBuilder(MongoDBApplication.class).web(true).run(args);
	}
}
