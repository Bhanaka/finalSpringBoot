package com.wings.usermanagement.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TbUserLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userLevelId ;

    @Column(name = "description")
    private String userDescription ;

    @Column(name = "isActive")
    private boolean userIsActive ;

}
