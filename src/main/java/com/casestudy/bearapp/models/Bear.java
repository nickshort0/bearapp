package com.casestudy.bearapp.models;

import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bears")
public class Bear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NonNull
    String name;
    @NonNull
    int baseAtk;
    @NonNull
    int baseDef;

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
