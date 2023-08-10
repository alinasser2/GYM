package com.mygym.gym.controller;

import com.mygym.gym.dto.UserDto;
import com.mygym.gym.entity.User;
import com.mygym.gym.mapper.UserMapper;
import com.mygym.gym.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class GymCont {

@Autowired
    public final UserMapper usermapper;
    public final UsersRepository userrepository;

    public GymCont( UserMapper usermapper, UsersRepository userrepository) {
        this.usermapper = usermapper;
        this.userrepository = userrepository;
    }
//
    @GetMapping("/{id}")
    public String map(@PathVariable("id") int id)
    {
        User user = userrepository.findById(id).get();
        UserDto dto = usermapper.mapToDto(user);
        System.out.println(dto.toString());
        return dto.toString();
    }


}
