## Database Schema for an Online Shopping Website

Designing a database schema for an online shopping website involves creating a structured representation of the data entities and their relationships. Below is a comprehensive overview of the key tables and their attributes that are typically included in such a schema.

### **Key Entities and Tables**

1. **Users Table**
   - **user_id** (Primary Key): Unique identifier for each user.
   - **username**: User's login name.
   - **email**: User's email address.
   - **password_hash**: Hashed password for security.
   - **created_at**: Timestamp of account creation.
   - **addresses**: Linked to an addresses table (one-to-many relationship).

2. **Addresses Table**
   - **address_id** (Primary Key): Unique identifier for each address.
   - **user_id** (Foreign Key): Links to Users table.
   - **address_line1**: Primary address line.
   - **address_line2**: Secondary address line (optional).
   - **city**: City name.
   - **state**: State name.
   - **zip_code**: Postal code.
   - **country**: Country name.

3. **Categories Table**
   - **category_id** (Primary Key): Unique identifier for each category.
   - **name**: Name of the category.
   - **parent_id** (Foreign Key): Links to itself for subcategories (self-referencing).

4. **Products Table**
   - **product_id** (Primary Key): Unique identifier for each product.
   - **name**: Product name.
   - **description**: Product description.
   - **base_price**: Base price of the product (before discounts).
   - **category_id** (Foreign Key): Links to Categories table.

5. **Product Attributes Table**
   - **attribute_id** (Primary Key): Unique identifier for each attribute type (e.g., color, size).
   - **product_id** (Foreign Key): Links to Products table.
   - **attribute_type**: Type of attribute (e.g., color, size).
   - **value**: Value of the attribute (e.g., red, large).

6. **Product SKUs Table**
   - **sku_id** (Primary Key): Unique identifier for each SKU.
   - **product_id** (Foreign Key): Links to Products table.
   - **price**: Price for this specific SKU variant.
   - **quantity_in_stock**: Available stock quantity.

7. **Cart Table**
   - **cart_id** (Primary Key): Unique identifier for each cart session.
   - **user_id** (Foreign Key): Links to Users table.
   - **total_cost**: Total cost of items in the cart.

8. **Cart Items Table**
   - **cart_item_id** (Primary Key): Unique identifier for each cart item.
   - **cart_id** (Foreign Key): Links to Cart table.
   - **sku_id** (Foreign Key): Links to Product SKUs table.
   - **quantity**: Quantity of the item in the cart.

9. **Orders Table**
   - **order_id** (Primary Key): Unique identifier for each order.
   - **user_id** (Foreign Key): Links to Users table.
   - **order_date**: Date when the order was placed.
   - **total_amount**: Total amount of the order.

10. **Order Items Table**
    - **order_item_id** (Primary Key): Unique identifier for each order item.
    - **order_id** (Foreign Key): Links to Orders table.
    - **sku_id** (Foreign Key): Links to Product SKUs table.
    - **quantity**: Quantity ordered.

11. **Payment Details Table**
    - **payment_id** (Primary Key): Unique identifier for payment records.
    - **order_id** (Foreign Key): Links to Orders table.
    - **amount_paid**: Amount paid in the transaction.
    - **payment_method**: Method used for payment (e.g., credit card, PayPal).
    - **payment_status**: Status of the payment.

12. **Wishlist Table**
    - **wishlist_id** (Primary Key): Unique identifier for the wishlist entry.
    - **user_id** (Foreign Key): Links to Users table.
    - **product_id** (Foreign Key): Links to Products table.

### Diagram Representation
To visualize these relationships, an Entity-Relationship Diagram (ERD) can be created using tools like dbdiagram.io or similar platforms, showcasing how these tables interact with one another through foreign keys and relationships.

### Normalization
The database schema should be normalized up to at least the third normal form to ensure data integrity and reduce redundancy. This involves organizing the data so that dependencies are properly enforced and anomalies are minimized during data operations[1][3][4].

This schema provides a robust foundation for an online shopping website, enabling efficient management of users, products, orders, and payments while ensuring scalability and performance as the business grows.

Citations:
[1] https://dev.to/ezzdinatef/ecommerce-database-design-1ggc
[2] https://www.tutorials24x7.com/mysql/guide-to-design-database-for-shopping-cart-in-mysql
[3] https://vertabelo.com/blog/er-diagram-for-online-shop/
[4] https://fabric.inc/blog/commerce/shopping-cart-database-design
[5] https://stackoverflow.com/questions/35612778/database-schema-for-an-online-shop
[6] https://www.geeksforgeeks.org/how-to-design-a-relational-database-for-e-commerce-website/