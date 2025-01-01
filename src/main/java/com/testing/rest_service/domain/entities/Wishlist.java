package com.testing.rest_service.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "wishlists")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishlistId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    // Assuming a many-to-many relationship with products.
    // You may need a join table for this relationship.

    // Getters and Setters
}
