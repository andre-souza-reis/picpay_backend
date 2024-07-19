/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reis.picpay.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import reis.picpay.controller.dto.TransferDto;
import reis.picpay.entity.Transfer;
import reis.picpay.entity.Wallet;
import reis.picpay.exception.InsuficientBalanceException;
import reis.picpay.exception.TransferNotAllowedForWalletTypeException;
import reis.picpay.exception.WalletNotFoundException;
import reis.picpay.repository.TransferRepository;
import reis.picpay.repository.WalletRepository;

/**
 *
 * @author andre.reis
 */
@Service
public class TransferService {
    
    private final TransferRepository transferRepository;
    private final WalletRepository walletrepository;

    public TransferService(TransferRepository transferRepository, WalletRepository walletrepository) {
        this.transferRepository = transferRepository;
        this.walletrepository = walletrepository;
    }

    @Transactional
    public Transfer transfer(TransferDto transferDto) {
        
        var sender = walletrepository.findById(transferDto.payer())
                .orElseThrow( () -> new WalletNotFoundException(transferDto.payer()));
        
        var receiver = walletrepository.findById(transferDto.payee())
                .orElseThrow( () -> new WalletNotFoundException(transferDto.payee()));
        
        validateTransfer(transferDto, sender);
        
        sender.debit(transferDto.value());
        receiver.credit(transferDto.value());
                
        var transfer = new Transfer(sender, receiver, transferDto.value());
        
        walletrepository.save(sender);
        walletrepository.save(receiver);
        var transferResult = transferRepository.save(transfer);
                
        return transferResult;
    }

    private void validateTransfer(TransferDto transferDto, Wallet sender) {
        
        if( !sender.isTransferAllowedForWalletType() )
        {
            throw new TransferNotAllowedForWalletTypeException();
        }
        
        if( !sender.isBalanceBiggerThan(transferDto.value()))
        {
            throw new InsuficientBalanceException(sender.getBalance());
        }
        
    }
    
}
