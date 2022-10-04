package com.transform.urlshortner

import com.google.common.base.Predicates
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@SpringBootApplication
open class UrlShortnerApplication

	fun main(args: Array<String>) {
		runApplication<UrlShortnerApplication>(*args)
	}

	@Bean
	fun swaggerSpringMvcPlugin(): Docket? {
		return Docket(DocumentationType.SWAGGER_2).select()
			.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build()
	}

