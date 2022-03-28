package com.projects.diningreviewsetup.model;
import lombok.*;
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

    public User(Long id, String username, String city, String state, Integer zipCode, Boolean peanutInterest, Boolean eggInterest, Boolean dairyInterest) {
        this.id = id;
        this.username = username;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.peanutInterest = peanutInterest;
        this.eggInterest = eggInterest;
        this.dairyInterest = dairyInterest;
    }
}



