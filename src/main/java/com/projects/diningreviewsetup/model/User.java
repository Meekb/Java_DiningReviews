package com.projects.diningreviewsetup.model;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
public @Data
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String display_name;
    private String city;
    private String state;
    private Integer zip_code;
    private Boolean peanut_interest;
    private Boolean egg_interest;
    private Boolean dairy_interest;
}



