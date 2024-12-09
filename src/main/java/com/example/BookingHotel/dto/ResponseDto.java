package com.example.BookingHotel.dto;

import com.example.BookingHotel.entity.Booking;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {

    private int statusCode;
    private String message;
    private String token;
    private String role;
    private String expirationTime;
    private String bookingConfirmationCode;
    private UserDto user;
    private RoomDto room;
    private Booking booking;
    private List<UserDto> userList;
    private List<RoomDto> roomList;
    private List<BookingDto> bookingList;
}
