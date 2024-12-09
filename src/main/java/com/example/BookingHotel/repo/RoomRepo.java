package com.example.BookingHotel.repo;

import com.example.BookingHotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {

    @Query("SELECT DISTINCT r.roomType FROM Room r")
    List<String> findDistinctRoomTypes();

    @Query("SELECT r FROM Room r WHERE r.roomType LIKE %:roomType% AND r.id NOT IN " +
            "(SELECT bk.room.id FROM Booking bk WHERE (bk.checkInDate <= :checkOutDate) AND (bk.checkOutDate >= :checkInDate))")
    List<Room> findAvailableRoomsByDateAndType(LocalDate checkInDate, LocalDate CheckOutDate, String roomType);

    @Query("SELECT r FROM r WHERE r.id NOT IN (SELECT b.room.id FROM booking b")
    List<Room> getAllAvailableRooms();
}
