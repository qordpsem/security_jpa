package com.example.security_jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="member")
public class Member {
    @Id
    private String id;
    private String pwd;
    private String name;
    private String role;
}