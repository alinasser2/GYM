package com.mygym.gym.mapper;

import com.mygym.gym.dto.ClassDto;
import com.mygym.gym.entity.Classes;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-10T14:52:22+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class ClassMapperImpl implements ClassMapper {

    @Override
    public ClassDto mapToDto(Classes classes) {
        if ( classes == null ) {
            return null;
        }

        ClassDto classDto = new ClassDto();

        return classDto;
    }

    @Override
    public Classes mapToDto(ClassDto dto) {
        if ( dto == null ) {
            return null;
        }

        Classes classes = new Classes();

        return classes;
    }
}
