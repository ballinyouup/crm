package com.insurenebula.crm.User;

import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "users")
public class User implements UserDetails{

    @Id
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID id;

    @OneToMany
    private Set<Authority> authorities;
    private String password;
    private String name;
    private String picture;
    
    @Column(unique = true)
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private String provider;
    private String providerId;
    private boolean enabled;
    
}

