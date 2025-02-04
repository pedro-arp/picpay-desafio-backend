package com.picpay.picpay_challenge.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@With
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Transference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "common_user_id")
    private CommonUser payer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CommonUser payee;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private LocalDateTime localDateTime = LocalDateTime.now();


}
