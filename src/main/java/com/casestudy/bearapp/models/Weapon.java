package com.casestudy.bearapp.models;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "weapons")
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NonNull
    String name;
    @NonNull
    int attack;
    /*@OneToMany(targetEntity = Bear.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "bear_fk", referencedColumnName = "id")
    List<Bear> bears;*/
}