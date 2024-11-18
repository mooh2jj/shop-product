package com.example.shopproject.entity;

import jakarta.persistence.*;
import lombok.*;

// AccessLevel.PROTECTED를 사용하여 외부에서 해당 생성자에 직접 접근하지 못하도록 제한
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "img_src")
    private String imgsrc = "https://via.placeholder.com/150x150/ffff00";

    private int price;

    private String description;

}