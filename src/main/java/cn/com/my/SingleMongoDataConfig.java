package cn.com.my;

/**
 * 单数据源实现集合中不出现_class字段
 * 
 * @author wangpeng1
 * @since 2018年12月29日
 */
// @Configuration
public class SingleMongoDataConfig {

	// @Bean
	// public MappingMongoConverter mappingMongoConverter(MongoDbFactory
	// factory,
	// MongoMappingContext context, BeanFactory beanFactory) {
	//
	// DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
	// MappingMongoConverter mappingConverter = new
	// MappingMongoConverter(dbRefResolver, context);
	// try {
	// mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
	// } catch (NoSuchBeanDefinitionException ignore) {
	//
	// }
	//
	// // 不保存_class字段到MongoDB
	// mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
	//
	// return mappingConverter;
	// }
}
