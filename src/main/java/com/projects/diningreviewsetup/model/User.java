package com.projects.diningreviewsetup.model;
import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public @Data
@NoArgsConstructor
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ZIPCODE")
    private Integer zipCode;
    @Column(name = "PEANUTINTEREST")
    private Boolean peanutInterest;
    @Column(name = "EGGINTEREST")
    private Boolean eggInterest;
    @Column(name = "DAIRYINTEREST")
    private Boolean dairyInterest;
}



