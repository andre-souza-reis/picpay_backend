/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reis.picpay.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reis.picpay.controller.dto.CreateWalletDto;
import reis.picpay.entity.Wallet;
import reis.picpay.service.WalletService;

/**
 *
 * @author andre.reis
 */
@RestController
public class WalletController {
    private final WalletService walletservice;

    public WalletController(WalletService walletservice) {
        this.walletservice = walletservice;
    }
    
    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet( @RequestBody @Valid CreateWalletDto dto)
    {
        var wallet = this.walletservice.createWallet(dto);
        
        return ResponseEntity.ok(wallet);
    }
    
    
}
