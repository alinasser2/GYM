package com.mygym.gym.service;

import com.mygym.gym.dto.ClassDto;
import com.mygym.gym.repository.ClassesRepository;

public interface ClassService {

    public boolean createClass(ClassDto dto);

}
