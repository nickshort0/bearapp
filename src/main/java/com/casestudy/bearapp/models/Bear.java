package com.casestudy.bearapp.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

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
    @NonNull
    int baseAtk;
    @NonNull
    int baseDef;

    String description;
    String image;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bear bear = (Bear) o;
        return id == bear.id && baseAtk == bear.baseAtk && baseDef == bear.baseDef && name.equals(bear.name) && Objects.equals(description, bear.description) && Objects.equals(image, bear.image) && Objects.equals(weapon, bear.weapon) && Objects.equals(armor, bear.armor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, baseAtk, baseDef, description, image, weapon, armor);
    }
}
