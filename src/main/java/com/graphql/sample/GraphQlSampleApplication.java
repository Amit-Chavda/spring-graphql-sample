package com.graphql.sample;

import com.graphql.sample.dto.UserDto;
import com.graphql.sample.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphQlSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlSampleApplication.class, args);
	}
	@Bean
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<User, UserDto>() {
			protected void configure() {
				map().setEmailAddress(source.getEmail());
				map().setPhysicalAddress(source.getAddress());
			}
		});
		modelMapper.addMappings(new PropertyMap<UserDto, User>() {
			protected void configure() {
				map().setEmail(source.getEmailAddress());
				map().setAddress(source.getPhysicalAddress());
			}
		});
		return modelMapper;
	}
}
