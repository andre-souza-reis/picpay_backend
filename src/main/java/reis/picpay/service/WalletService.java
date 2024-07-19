/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reis.picpay.service;

import org.springframework.stereotype.Service;
import reis.picpay.controller.dto.CreateWalletDto;
import reis.picpay.entity.Wallet;
import reis.picpay.exception.WalletDataAlreadyExistsException;
import reis.picpay.repository.WalletRepository;

/**
 *
 * @author andre.reis
 */
@Service
public class WalletService {
    
    private WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }
    
    public Wallet createWallet( CreateWalletDto dto )
    {
        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        
        if (walletDb.isPresent())
        {
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
        }
        
        return walletRepository.save( dto.toWallet() );
    }
}
