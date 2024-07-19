/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reis.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

/**
 *
 * @author andre.reis
 */
public class WalletDataAlreadyExistsException extends PicPayException {

    private String detail;
    
    public WalletDataAlreadyExistsException(String detail) {
        this.detail = detail;
    }
    
    

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        
        pb.setTitle("Wallet data already exists");
        pb.setDetail(detail);
        
        return pb;
    }
    
}
