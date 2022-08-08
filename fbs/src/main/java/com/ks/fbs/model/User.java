package com.ks.fbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.engine.internal.Cascade;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, unique = true, length = 45)
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @NotEmpty
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Transient
    private String passwordConfirm;

    private boolean isEnabled;

    private String phone;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="user_role",
            joinColumns = {@JoinColumn(name="user_id",referencedColumnName = "id")},
            inverseJoinColumns ={@JoinColumn(name="role_id",referencedColumnName = "id")}
    )
    private Set<Role> roles =null;

    private String createBy;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    private String updateBy;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User(User user) {
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.password = user.password;
        this.isEnabled = user.isEnabled;
        this.roles = user.roles;
    }


}
