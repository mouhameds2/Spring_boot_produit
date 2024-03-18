package sully.group.products.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.CloseableThreadContext;

import java.time.Instant;

@Builder
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Entity
@Table(name ="avis")
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private Instant dateCreation;

    @ManyToOne(cascade = CascadeType.ALL)

    private User user;

}
