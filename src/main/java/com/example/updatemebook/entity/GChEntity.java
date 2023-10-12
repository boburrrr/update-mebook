package com.example.updatemebook.entity;

import com.example.updatemebook.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "gchs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GChEntity extends BaseEntity{
    private String name;
    @ManyToOne
    private UserEntity user;
    @ManyToMany
    private List<UserEntity> admins;
    private Boolean secure;
    private Boolean block;
    @Enumerated(EnumType.STRING)
    private Type type;
}
