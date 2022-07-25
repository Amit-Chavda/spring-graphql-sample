package com.graphql.sample;

import com.graphql.sample.dto.AddressDto;
import com.graphql.sample.dto.UserDto;
import com.graphql.sample.entity.Address;
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

        modelMapper.addMappings(new PropertyMap<Address, AddressDto>() {
            @Override
            protected void configure() {
                map().setAddressLine1(source.getStreetName());
                map().setAddressLine2(source.getAdditionalStreet());
                map().setAddressLine3(source.getCity());
                map().setAddressLine4(source.getPobox());
                map().setAddressLine5(source.getState());
                map().setAddressPostCode(source.getPostcode());
            }
        });
        modelMapper.addMappings(new PropertyMap<AddressDto, Address>() {
            @Override
            protected void configure() {
                map().setStreetName(source.getAddressLine1());
                map().setAdditionalStreet(source.getAddressLine2());
                map().setCity(source.getAddressLine3());
                map().setPobox(source.getAddressLine4());
                map().setState(source.getAddressLine5());
                map().setPostcode(source.getAddressPostCode());
            }
        });
        modelMapper.addMappings(new PropertyMap<User, UserDto>() {
            protected void configure() {
                map().setEmailAddress(source.getEmail());
                map().getAddress().setAddressLine1(source.getAddress().getStreetName());
                map().getAddress().setAddressLine2(source.getAddress().getAdditionalStreet());
                map().getAddress().setAddressLine3(source.getAddress().getCity());
                map().getAddress().setAddressLine4(source.getAddress().getPobox());
                map().getAddress().setAddressLine5(source.getAddress().getState());
                map().getAddress().setAddressPostCode(source.getAddress().getPostcode());
            }
        });
        modelMapper.addMappings(new PropertyMap<UserDto, User>() {
            protected void configure() {
                map().setEmail(source.getEmailAddress());
                map().getAddress().setStreetName(source.getAddress().getAddressLine1());
                map().getAddress().setAdditionalStreet(source.getAddress().getAddressLine2());
                map().getAddress().setCity(source.getAddress().getAddressLine3());
                map().getAddress().setPobox(source.getAddress().getAddressLine4());
                map().getAddress().setState(source.getAddress().getAddressLine5());
                map().getAddress().setPostcode(source.getAddress().getAddressPostCode());
            }
        });
        return modelMapper;
    }
}
