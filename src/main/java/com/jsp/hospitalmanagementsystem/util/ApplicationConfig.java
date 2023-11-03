package com.jsp.hospitalmanagementsystem.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

	@Bean
	 public Docket docket() {
		 Contact contact=new Contact("infosys", "www.infosys.com", "info@abc.in");
		 
		 List< VendorExtension> lists=new ArrayList<>();
		 
		 ApiInfo apiInfo=new ApiInfo("Hospital management sysytem", "hospital managing app","vresion 1.0", "1yr of free service", contact,
				 "www.infolicence.com", "infolicence.com", lists);
		 
		 return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.jsp.hospitalmanagementsystem"))
				 .build().apiInfo(apiInfo).useDefaultResponseMessages(false);
		 
	 }
}