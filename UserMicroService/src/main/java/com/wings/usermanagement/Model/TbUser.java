package com.wings.usermanagement.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId ;

    @Column(name = "username")
    private String userName ;

    @Column(name = "password")
    private String userPassword ;

    @Column(name = "email")
    private String userEmail ;
    @Column(name = "isActive")
    private boolean useIsActive ;

}
