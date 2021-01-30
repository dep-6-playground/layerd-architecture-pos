package lk.ijse.dep.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailPK implements Serializable {
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "item_code")
    private String itemCode;
}
