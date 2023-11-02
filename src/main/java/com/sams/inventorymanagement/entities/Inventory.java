package com.sams.inventorymanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Represents the inventory of a specific item in a particular store. This entity contains a unique identifier,
 * references to the associated store and item, the current quantity in stock, and a minimum quantity threshold.
 */
@Getter
@Setter
@Entity
@Table(name = "inventory", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"store_id", "item_id"})})
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    /**
     * The unique identifier for the inventory.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The store associated with the inventory. It is required and cannot be null.
     */
    @ManyToOne
    @NotNull(message = "An inventory must be associated with a store")
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    /**
     * The item associated with the inventory. It is required and cannot be null.
     */
    @ManyToOne
    @NotNull(message = "An inventory must be associated with an item")
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    /**
     * The current quantity of the item in stock. The quantity must be greater than or equal to 1.
     */
    @Min(value = 1, message = "Inventory must have at least 1 quantity in stock")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /**
     * The minimum quantity threshold: the minimum quantity required in the store. It is initially set to 0.
     */
    @Column(name = "threshold")
    private Integer threshold = 0;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated = LocalDateTime.now();
}
