/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reis.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reis.picpay.entity.WalletType;

/**
 *
 * @author andre.reis
 */
@Repository
public interface WalletTypeRepository extends JpaRepository<WalletType, Long>{
    
}
