package com.example.updatemebook.entity.contact;

import com.example.updatemebook.entity.BaseEntity;
import com.example.updatemebook.entity.GChEntity;
import com.example.updatemebook.entity.Type;
import com.example.updatemebook.entity.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity(name = "subscrips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscrip extends BaseEntity {
    @ManyToOne
    private UserEntity user1;
    @ManyToOne
    private UserEntity user2;
    @ManyToOne
    private GChEntity gch;
    @Enumerated(EnumType.STRING)
    private Type type;
}
