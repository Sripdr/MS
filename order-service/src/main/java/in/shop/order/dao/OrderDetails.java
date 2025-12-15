package in.shop.order.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Integer orderId;

    private  Integer orderQuantity;

    @CreatedDate
    private LocalDateTime orderDate;

    private  String orderPaymentMode;

    private  String orderStatus;

    private Integer productId;


 // Or CascadeType.PERSIST if Address is managed elsewhere
 /*@OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name = "a_id", referencedColumnName = "aId")*/
    @OneToOne(

            orphanRemoval = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            }
    )
    private Address address;


}
