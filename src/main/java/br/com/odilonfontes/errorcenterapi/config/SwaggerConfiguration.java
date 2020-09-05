package br.com.odilonfontes.errorcenterapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

import static br.com.odilonfontes.errorcenterapi.config.AuthorizationServerConfiguration.CLIENT_ID;
import static br.com.odilonfontes.errorcenterapi.config.AuthorizationServerConfiguration.CLIENT_SECRET;

@Configuration
public class SwaggerConfiguration {

    private static final String API_INFO_TITLE = "Error Center API";
    private static final String API_INFO_DESCRIPTION = "API Rest para que as aplicações e serviços possam gravar" +
            "eventos de log em banco de dados relacional.";
    private static final String API_INFO_SNAPSHOT = "SNAPSHOT";
    private static final Contact API_INFO_CONTACT = new Contact("Odilon Fontes",
                                                                "https://github.com/odilonfontes", null);
    private static final String API_INFO_LICENSE_TITLE = "License of API";
    private static final String API_INFO_LICENSE_URL = "https://github.com/odilonfontes/error-center-api/" +
            "blob/master/LICENSE";
    public static final String API_INFO_TERMS_OF_SERVICE_URL = null;
    public static final String PATH_API = "/api/**";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant(PATH_API))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                API_INFO_TITLE,
                API_INFO_DESCRIPTION,
                API_INFO_SNAPSHOT,
                API_INFO_TERMS_OF_SERVICE_URL,
                API_INFO_CONTACT,
                API_INFO_LICENSE_TITLE,
                API_INFO_LICENSE_URL,
                Collections.emptyList());
    }

}
