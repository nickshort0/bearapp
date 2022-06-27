package com.casestudy.bearapp.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "bears")
public class Bear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank @NonNull
    String name;
    @NotBlank @NonNull
    int baseAtk;
    @NotBlank @NonNull
    int baseDef;

    /*@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "user_fk", referencedColumnName = "id")
    User user;*/
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "weap_fk", referencedColumnName = "id")
    Weapon weapon;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "arm_fk", referencedColumnName = "id")
    Armor armor;

    public Bear(@NonNull String name, @NonNull int baseAtk, @NonNull int baseDef, Weapon weapon, Armor armor) {
        this.name = name;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.weapon = weapon;
        this.armor = armor;
    }
}
