package com.win.userservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    private Long id;
    private String username;
    String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String phone;
    private Date dob;
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Lob
    private String address;

//    @OneToOne(mappedBy = "user")
//    private Loan loans;


    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

//    @OneToMany(mappedBy = "user",cascade = CascadeType.DETACH)
//    @JsonManagedReference
//    private Set<AccountBank> accountBanks;
//
//
//    @OneToOne
//    @JoinColumn(name = "fastLoan_id") // Cột khóa ngoại trong bảng User, liên kết với Loan
//    private FastLoan fastLoan;
//    @ManyToOne
//    @JoinColumn(name = "loan_id")
//    @JsonBackReference  // Ngừng serialize "loan" để tránh vòng lặp
//    private Loan loan;
}

