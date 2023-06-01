package uz.pdp.practice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brandName;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String ram;

    @Column(nullable = false)
    private Integer storage;

    @Column(nullable = false, unique = true)
    private String mac_address;

}
