package com.bridgwater.accessor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Accessor {

    @Value("${moviedb.url}")
    public String movieDBUrl;

    @Value("${api.key}")
    public String apiKey;

    @Value("${bearer.token}")
    public String token;


}
