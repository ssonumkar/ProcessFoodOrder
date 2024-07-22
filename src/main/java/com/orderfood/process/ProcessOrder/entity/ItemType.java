package com.orderfood.process.ProcessOrder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item_type")
@Getter
@Setter
@NoArgsConstructor
public class ItemType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String type_name;

    private String description;
}
