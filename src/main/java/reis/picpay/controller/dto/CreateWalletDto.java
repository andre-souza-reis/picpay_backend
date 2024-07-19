/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reis.picpay.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import reis.picpay.entity.Wallet;
import reis.picpay.entity.WalletType;

/**
 *
 * @author andre.reis
 */
public record CreateWalletDto(
        @NotBlank String fullName,
        @NotBlank String cpfCnpj,
        @NotBlank String email,
        @NotBlank String password,
        @NotNull WalletType.Enum walletType) {
    
    public Wallet toWallet()
    {
            return new Wallet(
            fullName,
            cpfCnpj,
            email,
            password,
            walletType.get());
    }
}
