package com.mygym.gym.entity;
import com.mygym.gym.Enum.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USERS")
@Component
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private int budget;
    private int hourlyRate;
    private boolean isEmployee;
    @Column(nullable = true)
    private int managerId;
    private LocalDateTime dateOfBirth;
    private Role role = Role.ROLE_USER;
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;
    public User(){}
    public User(int hourlyRate, String name, String email, String password, int budget, boolean is_employee, int manager_id, LocalDateTime dateOfBirth) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.budget = budget;
        this.hourlyRate = hourlyRate;
        this.isEmployee = is_employee;
        this.managerId = manager_id;
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.name());
        grantedAuthorityList.add(grantedAuthority);
        return grantedAuthorityList;
    }

    @Override
    public String getUsername() {
        return this.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}