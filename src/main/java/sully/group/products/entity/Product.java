package sully.group.products.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int price;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Avis> avis;

}
