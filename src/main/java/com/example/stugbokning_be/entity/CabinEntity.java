package com.example.stugbokning_be.entity;

import com.example.stugbokning_be.model.CabinModel;
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
@Table(name = "CABIN")
public class CabinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME", nullable = false )
    private String name;
    @Column(name = "PRICE", nullable = false)
    private int price;
    @Column(name = "SIZE", nullable = false)
    private int size;
    @CreationTimestamp
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "UPDATED")
    private LocalDateTime updatedAt;

    public CabinModel toModel() {
        return new CabinModel(
                this.getId(), this.getName(), this.getPrice(), this.getSize()
        );
    }
}
