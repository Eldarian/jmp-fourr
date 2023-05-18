package com.eldarian.jmpfour.apiclient;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "web-client")
public class WebClientProps {

    private String baseUrl;
}
