package learning.datascience.shailu.project1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

@Configuration
@EnableSwagger2
public class Swagger2Configurer implements WebMvcConfigurer {

    @Bean
    public Docket api(ServletContext servletContext) {
        return new Docket(DocumentationType.SWAGGER_2)

                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("learning.datascience.shailu.project1.controller"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(apiEndPointsInfo());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot REST API")
                .description("DataScience REST API")
                .contact(new Contact("DataScience Team", "www.test.com", "datascience@gmail.com"))
                .version("1.0.0")
                .build();
    }

}
