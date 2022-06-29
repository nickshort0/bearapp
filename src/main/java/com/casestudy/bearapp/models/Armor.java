package com.casestudy.bearapp.models;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "armor")
public class Armor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NonNull @NotBlank
    String name;
    @NonNull
    int defense;
    /*@OneToMany(targetEntity = Bear.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "bear_fk", referencedColumnName = "id")
    List<Bear> Bears;*/
}