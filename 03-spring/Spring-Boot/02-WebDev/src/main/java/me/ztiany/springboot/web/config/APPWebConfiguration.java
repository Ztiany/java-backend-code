package me.ztiany.springboot.web.config;

import lombok.extern.slf4j.Slf4j;
import me.ztiany.springboot.web.bean.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配置 WebMVC。
 */
@Component
@Slf4j
public class APPWebConfiguration {

    @Bean
    public HiddenHttpMethodFilter provideAppHiddenHttpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        //_method 其实是默认值，不过我们也可以修改。
        hiddenHttpMethodFilter.setMethodParam("_method");
        return hiddenHttpMethodFilter;
    }

    @Bean
    public WebMvcConfigurer provideAppWebMvcConfigurer() {
        return new WebMvcConfigurer() {

            /**
             * 自定义内容协商策略。
             */
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypes = new HashMap<>();
                mediaTypes.put("json", MediaType.APPLICATION_JSON);
                mediaTypes.put("xml", MediaType.APPLICATION_XML);

                //Http 请求时，使用下面两种方式开启内容协商
                // 1. Header 中设置 Accept=application/x-guigu 就会使用对应的 CustomMessageConverter
                // 2. 请求参数中加上 format 参数，比如：http://192.168.199.149:8082/web/test/person?format=x-guigu
                mediaTypes.put("gg", MediaType.parseMediaType("application/x-guigu"));//对应 CustomMessageConverter

                //指定支持哪些方式来进行内容协商
                //以 format 请求参数来协商
                ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
                parameterStrategy.setParameterName("format");
                //以 Header 的 Accept 来协商
                HeaderContentNegotiationStrategy strategy = new HeaderContentNegotiationStrategy();

                configurer.strategies(Arrays.asList(parameterStrategy, strategy));
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                //CustomMessageConverter 用于支持 application/x-guigu 内容协议。
                converters.add(new CustomMessageConverter());
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
            }

            @Override
            public void addFormatters(FormatterRegistry registry) {
                /* 用来支持 WebDemoController 的 saveUser 方法，Pet 对象自定义解析。即将表单提交的数据 "啊猫,3"  转换为 Pet 对象。  */
                Converter<String, Pet> converter = new Converter<String, Pet>()/*不要省略，不然会报错。*/ {
                    @Override
                    public Pet convert(String source) {
                        // source = "啊猫,3"
                        if (!StringUtils.isEmpty(source)) {
                            Pet pet = new Pet();
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                            return pet;
                        }
                        return null;
                    }
                };
                registry.addConverter(converter);
            }

            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                //不移除请求路径中的 ; 号，以此来支持矩阵变量。
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }

}