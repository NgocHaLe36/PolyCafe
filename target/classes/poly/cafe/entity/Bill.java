/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Setter
public class Bill {

    private Long id;
    private String username;
    private Integer cardId;
    @Builder.Default
    private Date checkin = new Date();
    private Date checkout;
    private Card card;
    private int status;

//    public int getCardId() {
//        return cardId;
//    }

    public enum Status {
        Pending, Completed, Canceled // thêm Canceled vào đây
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Card getCard() {
        return card;
    }

    public Long getId() {
        return id;
    }
}

