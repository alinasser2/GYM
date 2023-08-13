package com.mygym.gym.service.serviceImpl;

import com.mygym.gym.dto.ClassDto;
import com.mygym.gym.dto.UserSubscriptionDto;
import com.mygym.gym.entity.Classes;
import com.mygym.gym.entity.User;
import com.mygym.gym.mapper.ClassMapper;
import com.mygym.gym.repository.ClassesRepository;
import com.mygym.gym.repository.UsersRepository;
import com.mygym.gym.service.ClassService;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.Optional;

@RequiredArgsConstructor
@Validated
@Service
public class ClassServiceImpl implements ClassService {

    public final ClassMapper mapper;
    public final ClassesRepository classRepository;
    public final UsersRepository userRepository;

    public boolean createClass(ClassDto classDto)
    {
        validateInput(classDto);
        Classes Class = mapper.mapToEntity(classDto);
        classRepository.save(Class);
        return true;
    }

    private void validateInput(ClassDto classDto) {
        if (classDto.getName().isEmpty()) {
            throw new ValidationException("Class name must not be empty");
        }
        if (classDto.getPrice() <= 0) {
            throw new ValidationException("Class price must be greater than 0");
        }
        if (classDto.getDuration() == null) {
            throw new ValidationException("Class duration must not be null");
        }
        if (classDto.getCoachId() <= 0) {
            throw new ValidationException("Coach id must be greater than 0");
        }
        isCoachExist(classDto);
    }

    private void isCoachExist(ClassDto classDto) {
        Optional<User> user = userRepository.findById(classDto.getCoachId());
        if(user.isEmpty() || !user.get().isEmployee()) {
            throw new ValidationException("No coach with this id");
        }
    }

    public boolean subscribe(UserSubscriptionDto dto)
    {
        Classes Class = dto.getClasses();
        dto.setAmountPaid(Class.getPrice());
        return true;
    }
}
