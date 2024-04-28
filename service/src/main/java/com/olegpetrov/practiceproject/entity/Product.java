package com.olegpetrov.practiceproject.entity;

import com.olegpetrov.practiceproject.dto.enums.Sex;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;

@Entity
@Getter
@Setter
@Builder
@ToString(of = "id")
@FieldNameConstants
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private double price;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(updatable = false)
    private int quantity;
}
