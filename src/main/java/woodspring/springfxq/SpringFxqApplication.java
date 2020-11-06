package woodspring.springfxq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class SpringFxqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFxqApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String appDescription, @Value("${application-version") String appVersion) {
		return new OpenAPI()
				.info(new Info().title("FX Quote API")
						        .version( appVersion)
						        .description( appDescription)
						        .termsOfService("http://swagger.io/terms/")
						        .license( new License().name("Woodspring FX Quote 0.0.0.0").url("http://springdoc.org")));
	}
}
