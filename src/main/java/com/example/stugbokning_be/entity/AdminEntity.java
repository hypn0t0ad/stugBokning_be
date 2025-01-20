package com.example.stugbokning_be.entity;

import com.example.stugbokning_be.model.AdminModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ADMIN")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;
    @Column(name = "PASSWORD", nullable = false, unique = true)
    private String password;
    @CreationTimestamp
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "UPDATED")
    private LocalDateTime updatedAt;

    public AdminModel toModel() {
        return new AdminModel(
                this.id, this.username, this.password
        );
    }
}
