package com.example.updatemebook.entity.contact;


import com.example.updatemebook.entity.BaseEntity;
import com.example.updatemebook.entity.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactEntity extends BaseEntity {
    @ManyToOne
    private UserEntity user;
    private String name;
    private String email;
    private Boolean block;
}
