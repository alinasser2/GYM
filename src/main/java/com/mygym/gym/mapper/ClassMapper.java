package com.mygym.gym.mapper;

import com.mygym.gym.dto.ClassDto;
import com.mygym.gym.entity.Classes;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface ClassMapper {
    ClassDto mapToDto(Classes classes);
    Classes mapToEntity(ClassDto dto);

}
