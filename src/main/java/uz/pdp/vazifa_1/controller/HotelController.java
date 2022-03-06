package uz.pdp.vazifa_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vazifa_1.entity.Hotel;
import uz.pdp.vazifa_1.payload.Hoteldto;
import uz.pdp.vazifa_1.service.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("/all")
    public HttpEntity<?> getAllHotel() {
        List<Hotel> all = hotelService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        Hotel hotel = hotelService.getById(id);
        return ResponseEntity.ok(hotel);
    }

    @PostMapping("/save")
    public HttpEntity<?> saveHotel(@RequestBody Hoteldto hoteldto) {
        String saveOrEdit = hotelService.saveOrEdit(hoteldto);
        return ResponseEntity.ok(saveOrEdit);
    }

    @PutMapping("/edit{id}")
    public HttpEntity<?> editHotel(@RequestBody Hoteldto hoteldto) {
        String saveOrEdit = hotelService.saveOrEdit(hoteldto);
        return ResponseEntity.ok(saveOrEdit);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteHotel(@PathVariable Integer id) {
        String deleteHotel = hotelService.deleteHotel(id);
        return ResponseEntity.ok(deleteHotel);
    }
}
