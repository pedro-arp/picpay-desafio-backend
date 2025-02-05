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
    @JoinColumn(name = "common_user_payee_id")
    private CommonUser commonUserPayee;

    @ManyToOne
    @JoinColumn(name = "retailer_payee_id")
    private Retailer retailerPayee;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private LocalDateTime localDateTime = LocalDateTime.now();


}
