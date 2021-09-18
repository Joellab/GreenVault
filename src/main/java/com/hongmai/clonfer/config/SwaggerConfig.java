package com.hongmai.clonfer.config;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author JiaweiWang
 * @date 2021/9/18
 * @description
 */
@EnableOpenApi
@ApiIgnore
@Controller
public class SwaggerConfig implements WebMvcConfigurer {

    private final String baseUrl;

    public SwaggerConfig(
            @Value("${springfox.documentation.swagger-ui.base-url:}") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Bean
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.OAS_30);

        ApiInfoBuilder builder = new ApiInfoBuilder();
        builder.title("Clonfer API");
        ApiInfo apiInfo = builder.build();
        docket.apiInfo(apiInfo);
        ApiSelectorBuilder selectorBuilder = docket.select();
        selectorBuilder.paths(PathSelectors.any());
        //使用@ApiOperation的方法会被提取到REST API中
        //selectorBuilder.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class));
        docket = selectorBuilder.build();
        List<SecurityScheme> apiKeys = Collections.singletonList(HttpAuthenticationScheme.JWT_BEARER_BUILDER
                .name("token")
                .build());
        docket.securitySchemes(apiKeys);
        AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] scopeArray = {scope};
        SecurityReference reference = new SecurityReference("token", scopeArray);
        List refList = new ArrayList();
        refList.add(reference);
        SecurityContext context = SecurityContext.builder().securityReferences(refList).build();
        List cxtList = new ArrayList();
        cxtList.add(context);
        docket.securityContexts(cxtList);

        return docket;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String baseUrl = StringUtils.trimTrailingCharacter(this.baseUrl, '/');
        registry.
                addResourceHandler(baseUrl + "/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(baseUrl + "/swagger-ui/")
                .setViewName("forward:" + baseUrl + "/swagger-ui/index.html");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry
//                .addMapping("/api/pet")
//                .allowedOrigins("http://editor.swagger.io");
//        registry
//                .addMapping("/v2/api-docs.*")
//                .allowedOrigins("http://editor.swagger.io");
    }

    @GetMapping(value = "/docs")
    @Operation(hidden = true)
    public ModelAndView home() {
        return new ModelAndView("redirect:/swagger-ui/index.html");
    }
}