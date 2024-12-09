package com.example.BookingHotel.repo;

import com.example.BookingHotel.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

    List<Booking> findByRoomId(Long roomId);

    List<Booking> findByBookingConfirmationCode(String bookingConfirmationCode);

    List<Booking> findByUserId(Long userId);

}
