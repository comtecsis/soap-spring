package com.company.webservice.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "CLIENT")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENT_ID")
    private Long clientId;

    @Column(name = "CLIENT_NAME")
    private String name;

    @Column(name = "CLIENT_LASTNAME")
    private String lastName;

    @Column(name = "CLIENT_PHONE")
    private String phone;

}
