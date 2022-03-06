package uz.pdp.vazifa_1.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.vazifa_1.entity.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room,Integer> {
    Page<Room> findAllByHotelId(Integer hotel_id, Pageable pageable);
}
