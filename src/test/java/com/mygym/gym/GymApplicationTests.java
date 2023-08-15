package com.mygym.gym;

import com.mygym.gym.entity.User;
import com.mygym.gym.repository.UsersRepository;
import com.mygym.gym.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;
import java.time.LocalDate;
import java.time.LocalTime;
@RequiredArgsConstructor
@SpringBootTest
class GymApplicationTests {

    private final UserService service;

    @MockBean
    private UsersRepository repository;

//    @Test
//    public void getUsersTest() {
//        LocalDate date = LocalDate.of(2002, 7, 1);
//        LocalTime time = LocalTime.of(0, 0, 0);
//        LocalDateTime dateTime = LocalDateTime.of(date, time);
//        when(repository.findAll()).thenReturn((List<User>) Stream
//                .of(new User(7999, "John Doe", "johndoe@example.com",
//                        "pass", 0, true, 1234,dateTime)));
//        assertEquals(1, service.retrieveAll().size());
//    }

}
