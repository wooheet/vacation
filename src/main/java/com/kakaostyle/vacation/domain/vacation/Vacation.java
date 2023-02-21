package com.kakaostyle.vacation.domain.vacation;

import com.kakaostyle.vacation.domain.BaseEntity;
import com.kakaostyle.vacation.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@Table(name = "vacations")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vacation extends BaseEntity {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @Column(name = "vacation_type")
    @Enumerated(EnumType.STRING)
    private VacationType vacationType;

    @Enumerated(EnumType.STRING)
    private VacationStatus status;

    @Column(name = "days_used", length = 3, nullable = false)
    private Double daysUsed;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 500)
    private String comment;
}

