package com.swarcs.k8sstarter.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SwaggerEnum {

    TITLE("Swarcs K8S Starter"),
    VERSION("0.0.1-SNAPSHOT"),
    DESCRIPTION("This is the starter for all microservice application as a starting point."),
    SERVICE_GROUP("swarcs-starter-ms"),
    CONTACT_NAME("SWARCS Support Team"),
    CONTACT_EMAIL("info@swarcs.com"),
    DEFAULT_PATTERN("/**");

    private final String value;

}
