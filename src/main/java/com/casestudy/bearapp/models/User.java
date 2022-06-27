package com.casestudy.bearapp.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank(message = "must provide username") @NonNull
    String username;
    @NotBlank(message = "must provide email") @Email @NonNull
    String email;
    @Setter(AccessLevel.NONE) @NonNull
    String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_bears",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    Set<Bear> bears = new LinkedHashSet<>();

    public void addBear(Bear bear){
        bears.add(bear);
    }

    public void removeBear(Bear bear){
        bears.remove(bear);
    }

}
