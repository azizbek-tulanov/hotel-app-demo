package uz.pdp.vazifa_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vazifa_1.entity.Hotel;
import uz.pdp.vazifa_1.entity.Room;
import uz.pdp.vazifa_1.payload.Hoteldto;
import uz.pdp.vazifa_1.payload.RoomDto;
import uz.pdp.vazifa_1.service.HotelService;
import uz.pdp.vazifa_1.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/all")
    public HttpEntity<?> getAllHotel() {
        List<Room> all = roomService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        Room room = roomService.getById(id);
        return ResponseEntity.ok(room);
    }

    @GetMapping("/getByHotelId/{hotelId}")
    public HttpEntity<?> getByHitelId(@PathVariable Integer hotelId,@RequestParam int page) {
        Page<Room> byHotelIdRoom = roomService.getByHotelIdRoom(hotelId, page);
        return ResponseEntity.ok(byHotelIdRoom);
    }

    @PostMapping("/save")
    public HttpEntity<?> saveHotel(@RequestBody RoomDto roomDto) {
        String saveOrEdit = roomService.saveOrEdit(roomDto);
        return ResponseEntity.ok(saveOrEdit);
    }

    @PutMapping("/edit{id}")
    public HttpEntity<?> editHotel(@RequestBody RoomDto roomDto) {
        String saveOrEdit = roomService.saveOrEdit(roomDto);
        return ResponseEntity.ok(saveOrEdit);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteHotel(@PathVariable Integer id) {
        String deleteRoom = roomService.deleteRoom(id);
        return ResponseEntity.ok(deleteRoom);
    }
}
