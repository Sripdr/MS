package in.shop.product.dao;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Integer productId;

    private String productName;

    private String productDescription;

    private  Double productPrice;

    private String productCategory;


}
