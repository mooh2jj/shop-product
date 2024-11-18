package com.example.shopproject.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {

    private Integer id;
    private String title;
    private String imgsrc;
    private int price;
    private String description;
}
