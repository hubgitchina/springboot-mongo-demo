package cn.com.my.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb.secondary")
@EnableMongoRepositories(basePackages = "cn.com.my.repository.secondary", mongoTemplateRef = SecondaryMongoConfig.MONGO_TEMPLATE)
public class SecondaryMongoConfig extends AbstractMongoConfig {

	protected static final String MONGO_TEMPLATE = "secondaryMongoTemplate";

	@Override
	@Bean(name = "secondaryMongoTemplate")
	public MongoTemplate getMongoTemplate() throws Exception {

		// 不保存_class字段到MongoDB
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver,
				new MongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));

		MongoTemplate secondaryMongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
		return secondaryMongoTemplate;

		// return new MongoTemplate(mongoDbFactory());
	}
}
