/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reis.picpay.controller.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 *
 * @author andre.reis
 */
public record TransferDto( 
        @DecimalMin("0.01") @NotNull BigDecimal value,
        @NotNull Long payer,
        @NotNull Long payee) {}
