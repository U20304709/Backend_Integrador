package com.sams.inventorymanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * A store.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store")
public class Store {
    /** Unique id for the store. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    /** The name of the store. */
    @Column(name = "name", nullable = false)
    private String name;
    /** The store address. */
    @Column(name = "address", nullable = false)
    private String address;
    /** The store email. */
    @Column(name = "email")
    private String email;
    /** The store phone of the category. */
    @Column(name = "phone", nullable = false)
    private String phone;
    /** The store type. */
    @Column(name = "phone", nullable = false)
    /** The inventories of the store. */
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventory> inventories;
}
