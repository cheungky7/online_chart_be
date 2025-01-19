package com.testing.rest_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//https://www.perplexity.ai/search/modelmapper-custom-mapping-_55jpPbJRwiFlxCUEJ8Wdg
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}