package me.ztiany.springboot.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/*
 * 1. Configuration 标注的类本身也是组件
 * 2. Configuration 的 proxyBeanMethods 属性
 *      - 当 proxyBeanMethods = true 时，如果外部环境调用 AppConfig 中的提供 bean 的方法，那么会从容器中找对象。
 *      - 当 proxyBeanMethods = false 时，如果外部环境调用 AppConfig 中的提供 bean 的方法，那么会直接调用方法本身。
 * 3. @Import 注解用于给容器注入组件，被导入的组件的名称为类的全路径名。
 * 4. @ImportResource  注解用于导入Spring的配置文件。
 * 5. @ConditionalXXX 类注解用于实现跳转装配，只有满足某个条件时，配置才会生效或失效。
 * 6. @ConfigurationProperties 类注解用于注入配置文件中的值。ConfigurationProperties
 * 7. @EnableConfigurationProperties 用于导入指定的类加入到容器中，并且对其开启属性配置注入。被导入的累上应该有 ConfigurationProperties 注解。
 */
@Configuration(proxyBeanMethods = true)
@Slf4j
public class AppConfig {

}