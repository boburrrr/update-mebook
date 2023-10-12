package com.example.updatemebook.entity.post;

import com.example.updatemebook.entity.BaseEntity;
import com.example.updatemebook.entity.GChEntity;
import com.example.updatemebook.entity.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEntity extends BaseEntity {
    @ManyToOne
    private UserEntity user;
    private String title;
    private String body;
    private String img;
    @ManyToOne
    private GChEntity channel;
}
