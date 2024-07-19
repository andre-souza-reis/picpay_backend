/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reis.picpay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 *
 * @author andre.reis
 */
@Entity
@Table( name = "tb_wallet_type" )
public class WalletType {
    
    public WalletType() {
    }

    public WalletType(Long Id, String description) {
        this.Id = Id;
        this.description = description;
    }
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long Id;
    
    private String description;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.Id);
        hash = 73 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WalletType other = (WalletType) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return Objects.equals(this.Id, other.Id);
    }
    
    
    
    public enum Enum
    {
        USER(1L, "user"),
        MERCHANT(2L, "merchant");

        private Enum(Long id, String description) {
            this.id = id;
            this.description = description;
        }
        
        private Long id;
        private String description;
        
        public WalletType get()
        {
            return new WalletType(id, description);
        }
        
        
    }
}
