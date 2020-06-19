package edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @NotBlank(message = "student number is required")
    @Column(unique = true )
    private String customerNumber;
    @NotBlank(message = "this field is required")
    private String fullName;
    @Column(nullable = true)
    private String phoneNumber;
   // @NotBlank(message = "Reservation date is required ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateOfBirth;

}
