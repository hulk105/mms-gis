package ua.nure.informationgismodels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class InformationGisModelsApplication {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Information GIS models API")
				.description("API Definitions of the Information GIS models project")
				.version("1.0.0")
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(InformationGisModelsApplication.class, args);
	}

}
