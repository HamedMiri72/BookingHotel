package com.example.BookingHotel.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequestDto {

    @NotNull(message = "Email is required.")
    private String email;
    @NotNull(message = "Password is required")
    private String password;
}
