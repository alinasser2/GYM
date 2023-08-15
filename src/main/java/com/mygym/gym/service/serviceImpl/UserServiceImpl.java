package com.mygym.gym.service.serviceImpl;

import com.mygym.gym.dto.UserDto;
import com.mygym.gym.entity.User;
import com.mygym.gym.mapper.UserMapper;
import com.mygym.gym.repository.ClassesRepository;
import com.mygym.gym.repository.UsersRepository;
import com.mygym.gym.service.UserService;
import jakarta.validation.ValidationException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


//@RequiredArgsConstructor
@NoArgsConstructor
@Service
@Primary
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository repository;
    @Autowired

    private UserMapper mapper;
    @Autowired

    private ClassesRepository classRepository;

    @Override
    public UserDto retrieveUser(int id) {
        if (id < 0)
        {
            throw new ValidationException("Id must be greater than zero.");
        }
        Optional<User> user = repository.findById(id);
        if (!user.isPresent())
        {
            throw new NoSuchElementException("No user with id "+ id);
        }
        return mapper.mapToDto(user.get());
    }

    public boolean signup(UserDto dto)
    {
            User user = mapper.mapToEntity(dto);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            repository.save(user);
            return true;
    }

    public List<User> retrieveAll(){

        return repository.findAll();
    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = repository.findByName(username);
//
//    }
}
