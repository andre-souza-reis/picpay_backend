/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reis.picpay.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reis.picpay.entity.Wallet;

/**
 *
 * @author andre.reis
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    public Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);
    
}
