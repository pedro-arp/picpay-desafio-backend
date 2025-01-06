package com.picpay.picpay_challenge.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

@With
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Retailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    @CNPJ
    private String cnpj;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

}
