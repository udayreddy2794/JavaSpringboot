package com.panduluv.springcoredemo.config;

import com.panduluv.springcoredemo.common.Coach;
import com.panduluv.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("Aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
