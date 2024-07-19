/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reis.picpay.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import reis.picpay.entity.Transfer;

/**
 *
 * @author andre.reis
 */
public interface TransferRepository extends JpaRepository<Transfer, UUID> {
    
}
