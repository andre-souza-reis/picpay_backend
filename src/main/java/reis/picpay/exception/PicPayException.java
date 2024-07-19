/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reis.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/**
 *
 * @author andre.reis
 */
public class PicPayException extends RuntimeException {
    
    public ProblemDetail toProblemDetail()
    {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        
        pb.setTitle("PicPay internal server error");
        
        return pb;
    }
    
}
