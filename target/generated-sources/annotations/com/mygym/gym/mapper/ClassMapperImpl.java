package com.mygym.gym.mapper;

import com.mygym.gym.dto.ClassDto;
import com.mygym.gym.entity.Classes;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T11:26:11+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class ClassMapperImpl implements ClassMapper {

    @Override
    public ClassDto mapToDto(Classes classes) {
        if ( classes == null ) {
            return null;
        }

        ClassDto classDto = new ClassDto();

        classDto.setName( classes.getName() );
        classDto.setDescription( classes.getDescription() );
        classDto.setPrice( classes.getPrice() );
        classDto.setDuration( classes.getDuration() );
        classDto.setCoachId( classes.getCoachId() );
        classDto.setDateTimes( classes.getDateTimes() );

        return classDto;
    }

    @Override
    public Classes mapToEntity(ClassDto dto) {
        if ( dto == null ) {
            return null;
        }

        Classes classes = new Classes();

        classes.setName( dto.getName() );
        classes.setDescription( dto.getDescription() );
        classes.setPrice( dto.getPrice() );
        classes.setDuration( dto.getDuration() );
        classes.setCoachId( dto.getCoachId() );
        classes.setDateTimes( dto.getDateTimes() );

        return classes;
    }
}
