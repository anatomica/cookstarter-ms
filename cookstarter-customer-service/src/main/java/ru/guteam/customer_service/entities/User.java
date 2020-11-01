package ru.guteam.customer_service.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.guteam.customer_service.entities.utils.enums.UsersTypeEnum;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_type")
    private UsersTypeEnum userType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Customer customer;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "enable")
    private boolean enable;


}
