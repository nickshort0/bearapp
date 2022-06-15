package com.casestudy.bearapp.models;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "armor")
public class Armor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NonNull
    String name;
    @NonNull
    int defense;
    @OneToMany(targetEntity = Bear.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "bear_fk", referencedColumnName = "id")
    List<Bear> Bears;
}