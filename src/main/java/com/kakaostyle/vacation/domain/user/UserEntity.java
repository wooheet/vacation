package com.kakaostyle.vacation.domain.user;

import com.kakaostyle.vacation.domain.BaseEntity;
import com.kakaostyle.vacation.domain.vacation.Vacation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.*;

@Entity
@Getter
@Builder
@DynamicInsert
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", length = 20)
    private String username;

    @Column(length = 64, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "available_vac_days", columnDefinition ="Default Value: 15.0")
    private Double availableVacDays;

    @Column(name = "requested_vac_days", columnDefinition ="Default Value: 0.0")
    private Double requestedVacDays;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Vacation> vacations;
}
