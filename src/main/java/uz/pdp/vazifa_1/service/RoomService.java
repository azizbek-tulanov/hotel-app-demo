package uz.pdp.vazifa_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.vazifa_1.entity.Hotel;
import uz.pdp.vazifa_1.entity.Room;
import uz.pdp.vazifa_1.payload.RoomDto;
import uz.pdp.vazifa_1.repo.HotelRepo;
import uz.pdp.vazifa_1.repo.RoomRepo;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    HotelRepo hotelRepo;

    public List<Room> getAll() {
        List<Room> all = roomRepo.findAll();
        return all;
    }

    public Room getById(Integer id) {
        Optional<Room> optionalRoom = roomRepo.findById(id);
        if (optionalRoom.isPresent()){
            return optionalRoom.get();
        }
        return null;
    }

    public String saveOrEdit(RoomDto roomDto) {
        Room room=new Room();
        if (roomDto.getId()!=null) {
            room=roomRepo.getById(roomDto.getId());
        }
        room.setNumber(roomDto.getNumber());
        room.setSize(roomDto.getSize());
        room.setFloor(roomDto.getFloor());
        Optional<Hotel> optionalHotel = hotelRepo.findById(roomDto.getHotelId());
        if (optionalHotel.isPresent()) {
            room.setHotel(optionalHotel.get());
        }
        roomRepo.save(room);
        return roomDto.getId()==null?"Room Saved":"Room edited";
    }

    public String deleteRoom(Integer id) {
        try {
            roomRepo.deleteById(id);
            return "Room Deleted";
        }
        catch (Exception e) {
            return "Room not found";
        }
    }

    public Page<Room> getByHotelIdRoom(Integer hotelId, int page) {
        Pageable pageable= PageRequest.of(page,2);
        Page<Room> roomPage = roomRepo.findAllByHotelId(hotelId, pageable);
        return roomPage;
    }
}
