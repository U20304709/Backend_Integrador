package com.sams.inventorymanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * An item available for store stocking. This entity represents individual items that stores can stock.
 */
@Entity
@Getter
@Setter
@Table(name = "item")
public class Item {
    /**
     * Unique id for the item.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The name of the item. It should be between 2 and 255 characters in length.
     */
    @NotBlank(message = "Item name cannot be blank")
    @Size(min = 1, max = 255, message = "Name should have a minimum of 2 characters and a maximum of 255")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    /**
     * The short description of the item. It should be between 10 and 255 characters in length.
     */
    @NotBlank(message = "Short description cannot be blank")
    @Size(min = 10, max = 255, message = "Short description should have a minimum of 10 characters and a maximum of 255")
    @Column(name = "short_description", nullable = false)
    private String shortDescription;

    /**
     * The long description of the item.
     */
    @Column(name = "long_description")
    private String longDescription;

    /**
     * The price of the item. It must be at least 0.01.
     */
    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.001", message = "Price must be at least 0.01")
    @Column(name = "price", nullable = false)
    private Double price;

    /**
     * The quantity of the item. It should be at least 1.
     */
    @Column(name = "quantity", nullable = false)
    private Integer quantity = 0;

    /**
     * The category of the item. It cannot be null and is eagerly fetched.
     */
    @NotNull(message = "Category cannot be null")
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    /**
     * The inventories that have this item.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<Inventory> inventories;

    /**
     * The purchase orders that have this item.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<PurchaseOrderItem> purchaseOrders;
}
