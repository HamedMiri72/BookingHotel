package com.example.BookingHotel.dto;


import com.example.BookingHotel.entity.Room;
import com.example.BookingHotel.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDto {

    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numOfAdults;
    private int numOfChildren;
    private int totalNumberOfGuest;
    private UserDto user;
    private RoomDto room;
    private String bookingConfirmationCode;


}
