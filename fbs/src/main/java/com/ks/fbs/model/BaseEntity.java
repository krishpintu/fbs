package com.ks.fbs.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String createBy;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    private String updateBy;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
