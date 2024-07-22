package com.orderfood.process.ProcessOrder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;
    private String customerId;
    private String restaurantId;
    private String orderDate;
    private String status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address deliveryAddress;

    private double totalAmount;
    private String paymentMethod;
    private String paymentStatus;
}
