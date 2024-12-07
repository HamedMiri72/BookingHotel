package com.example.BookingHotel.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "check in date is required!")
    private LocalDate checkInDate;

    @Future(message = "check out date must be in future!")
    private LocalDate checkOutDate;

    @Min(value = 1, message = "number of adults must not be less than 1!")
    private int numOfAdults;

    @Min(value = 0, message = "number of Children must not be less than 0!")
    private int numberOdChildren;

    private int totalNumberOfGuest;

    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public void calculateTotalNumberOfGuest(){
        this.totalNumberOfGuest = this.numOfAdults + this.numberOdChildren;
    }

    public void setNumOfAdults(@Min(value = 1, message = "number of adults must not be less than 1!") int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();
    }

    public void setNumberOdChildren(@Min(value = 0, message = "number of Children must not be less than 0!") int numberOdChildren) {
        this.numberOdChildren = numberOdChildren;
        calculateTotalNumberOfGuest();
    }
}
