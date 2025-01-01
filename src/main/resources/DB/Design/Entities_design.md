To create JPA entities for the online shopping website schema, we will define each entity class corresponding to the tables identified in the database schema. Each class will include annotations to map the class to a database table and its fields to the table columns.

### JPA Entity Classes

1. **User Entity**
```java
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String email;
    private String passwordHash;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Address> addresses;

    // Getters and Setters
}
```

2. **Address Entity**
```java
import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    // Getters and Setters
}
```

3. **Category Entity**
```java
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products;

    // Getters and Setters
}
```

4. **Product Entity**
```java
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;
    private String description;
    private Double basePrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductSKU> skus;

    // Getters and Setters
}
```

5. **ProductSKU Entity**
```java
import javax.persistence.*;

@Entity
@Table(name = "product_skus")
public class ProductSKU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skuId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Double price;
    private Integer quantityInStock;

    // Getters and Setters
}
```

6. **Cart Entity**
```java
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private User user; 

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> items;

   // Getters and Setters 
}
```

7. **CartItem Entity**
```java
import javax.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long cartItemId;

   @ManyToOne
   @JoinColumn(name = "cart_id")
   private Cart cart;

   @ManyToOne
   @JoinColumn(name = "sku_id")
   private ProductSKU sku; 

   private Integer quantity; 

   // Getters and Setters 
}
```

8. **Order Entity**
```java
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   private Long orderId; 

   @ManyToOne 
   @JoinColumn(name = "user_id") 
   private User user; 

   private Date orderDate; 
   private Double totalAmount; 

   @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) 
   private Set<OrderItem> items; 

   // Getters and Setters 
}
```

9. **OrderItem Entity**
```java
import javax.persistence.*;

@Entity 
@Table(name = "order_items") 
public class OrderItem { 
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   private Long orderItemId; 

   @ManyToOne 
   @JoinColumn(name = "order_id") 
   private Order order; 

   @ManyToOne 
   @JoinColumn(name = "sku_id") 
   private ProductSKU sku; 

   private Integer quantity; 

   // Getters and Setters 
}
```

10. **Payment Entity**
```java
import javax.persistence.*;

@Entity 
@Table(name = "payments") 
public class Payment { 
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   private Long paymentId; 

   @ManyToOne 
   @JoinColumn(name = "order_id") 
   private Order order; 

   private Double amountPaid; 
   private String paymentMethod; 
   
   // Getters and Setters 
}
```

11. **Wishlist Entity**
```java
import javax.persistence.*;

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
```

### Explanation

- Each entity is annotated with `@Entity` to indicate that it is a JPA entity.
- The `@Table` annotation specifies the table name in the database.
- The `@Id` annotation marks the primary key, while `@GeneratedValue` defines how the primary key is generated.
- Relationships between entities are defined using annotations like `@ManyToOne`, `@OneToMany`, and `@JoinColumn`.
- Each entity includes getters and setters for encapsulation.

This structure provides a solid foundation for implementing the online shopping website's backend using JPA, allowing for efficient data management and interaction with the underlying database.

Citations:
[1] https://vertabelo.com/blog/er-diagram-for-online-shop/
[2] https://www.geeksforgeeks.org/how-to-design-a-relational-database-for-e-commerce-website/
[3] https://www.geeksforgeeks.org/how-to-design-a-database-for-shopping-cart/