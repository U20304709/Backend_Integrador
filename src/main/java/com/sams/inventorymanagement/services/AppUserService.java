package com.sams.inventorymanagement.services;

import com.sams.inventorymanagement.dto.AppUserDTO;
import com.sams.inventorymanagement.entities.AppUser;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Service interface for managing application users (AppUser entities).
 */
public interface AppUserService {
    /**
     * Get a list of all users.
     *
     * @return A list of AppUser entities.
     */
    List<AppUser> getAllUsers();

    /**
     * Get a user by their unique identifier.
     *
     * @param id The unique identifier of the user.
     * @return The requested AppUser, or null if not found.
     */
    AppUser getUserById(Long id);

    /**
     * Get a user by their email.
     *
     * @param email The unique identifier of the user.
     * @return The requested AppUser, or null if not found.
     */
    AppUser getUserByEmail(String email);

    /**
     * Get a user by their username.
     *
     * @param username The unique identifier of the user.
     * @return The requested AppUser, or null if not found.
     */
    AppUser getUserByUsername(String username);

    /**
     * Create a new user.
     *
     * @param user The user to be created.
     * @return The created AppUser.
     */
    AppUser createUser(AppUser user);



    /**
     * Delete a user by their unique identifier.
     *
     * @param id The unique identifier of the user to be deleted.
     */
    void deleteUser(Long id);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    /**
     * Update an existing user.
     *
     * @param admin The user performing the update.
     *
     * @param updatedUser The user to be updated.
     * @return The updated AppUser, or null if the user is not found.
     */
    @Transactional
    AppUser updateUser(AppUser admin, AppUserDTO updatedUser);
}
