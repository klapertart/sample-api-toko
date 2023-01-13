package klapertart.lab.toko.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

@Entity
@Table(name = "supplier")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(length = 50, unique = true, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String address;

    @ManyToMany(mappedBy = "suppliers")
    @JsonBackReference
    private List<Product> products;

}
