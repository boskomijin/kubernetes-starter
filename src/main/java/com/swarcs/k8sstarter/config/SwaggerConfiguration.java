/*
 * Software Architectures and Solutions d.o.o. Novi Sad. Copyright 2015-2020.
 */

package com.swarcs.k8sstarter.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * The <code>SwaggerConfiguration</code> class is a config class which holds all the basic information required for open
 * api documentation.
 *
 * @author Bosko Mijin
 */
@Configuration
@Profile("!production")
public class SwaggerConfiguration {

    @Bean
    public OpenAPI apiInfo() {
        Contact contact = new Contact();
        contact.setName(SwaggerEnum.CONTACT_NAME.getValue());
        contact.setEmail(SwaggerEnum.CONTACT_EMAIL.getValue());
        return new OpenAPI().info(new Info()
                        .title(SwaggerEnum.TITLE.getValue())
                        .description(SwaggerEnum.DESCRIPTION.getValue())
                        .contact(contact)
                        .version(SwaggerEnum.VERSION.getValue())
                );
    }

    @Bean
    public GroupedOpenApi serviceApi() {
        return GroupedOpenApi.builder().group(SwaggerEnum.SERVICE_GROUP.getValue())
                .pathsToMatch(SwaggerEnum.DEFAULT_PATTERN.getValue()).build();
    }
}
