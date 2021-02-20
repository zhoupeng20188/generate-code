mybatis.configuration.mapUnderscoreToCamelCase=true
logging.level.${packageName}.mapper=debug

spring.main.allow-bean-definition-overriding=true

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=${db.url}
spring.datasource.username=${db.username}
spring.datasource.password=${db.password}
#  存放mybatis映射文件的位置
mybatis.mapper-locations=classpath*:mapper/*Mapper.xml
#  存放实体类文件的位置
mybatis.type-aliases-package=${packageName}.model