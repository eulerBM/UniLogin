package com.login.back_end.user;

import com.login.back_end.user.enums.Providers;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrivate;

    @Column(nullable = false, updatable = false, unique = true)
    private UUID idPublic;

    @Column(length = 100)
    private String name;

    @Column(length = 150, unique = true)
    private String email;

    @Column(length = 150)
    private String password;

    @Enumerated(EnumType.STRING)
    private Set<Providers> providers = new HashSet<>();

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

    @PrePersist
    public void prePersist(){
        this.idPublic = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public User() {
    }

    public Set<Providers> getProviders() {
        return providers;
    }

    public void setProviders(Set<Providers> providers) {
        this.providers = providers;
    }

    public Long getIdPrivate() {
        return idPrivate;
    }

    public UUID getIdPublic() {
        return idPublic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

