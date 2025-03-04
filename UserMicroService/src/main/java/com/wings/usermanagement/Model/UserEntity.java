package com.wings.usermanagement.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // This tells JPA to use auto-increment
//    @Column(name = "id", columnDefinition = "BIGSERIAL")  // This explicitly sets the column type to
    @Column(name = "id")  // This explicitly sets the column type to BIGSERIAL

    private Long id;
    @Column(name = "name")
    private String userName ;

}
