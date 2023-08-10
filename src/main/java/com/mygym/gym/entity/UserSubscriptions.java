package com.mygym.gym.entity;
import lombok.*;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "USERS_SUBSCRIPTIONS")
@Data
@Component
public class UserSubscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Classes classId;
    private int amountPaid;
    @OneToMany
    private List<Offer> offers;
}