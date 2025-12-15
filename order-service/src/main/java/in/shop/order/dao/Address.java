package in.shop.order.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address_details")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer Id;

    private String flatNoAndStreet;

    private String city;

    private String state;


}
