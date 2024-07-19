/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reis.picpay.exception;

import java.math.BigDecimal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/**
 *
 * @author andre.reis
 */
public class InsuficientBalanceException extends PicPayException {

    private BigDecimal balance;

    public InsuficientBalanceException(BigDecimal value) {
        this.balance = value;
    }
       
    
    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        
        pb.setTitle("Insuficient Ballance");
        pb.setDetail("You cannot transfer a value bigger than: " + balance);
        
        return pb;
    }
    
}
