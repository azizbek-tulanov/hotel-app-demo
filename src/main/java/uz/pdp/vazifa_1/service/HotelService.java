package uz.pdp.vazifa_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.vazifa_1.entity.Hotel;
import uz.pdp.vazifa_1.payload.Hoteldto;
import uz.pdp.vazifa_1.repo.HotelRepo;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepo hotelRepo;

    public List<Hotel> getAll() {
        List<Hotel> all = hotelRepo.findAll();
        return all;
    }

    public Hotel getById(Integer id) {
        Optional<Hotel> hotelOptional = hotelRepo.findById(id);
        if (hotelOptional.isPresent()) {
            return hotelOptional.get();
        }
        return null;
    }

    public String saveOrEdit(Hoteldto hoteldto) {
        Hotel hotel = new Hotel();
        if (hoteldto.getId()!=null) {
            hotel=hotelRepo.getById(hoteldto.getId());
        }
        hotel.setName(hoteldto.getName());
        hotelRepo.save(hotel);
        return hoteldto.getId()!=null?"Hotel edited":"Hotel Saved";
    }

    public String deleteHotel(Integer id) {
        try {
            hotelRepo.deleteById(id);
            return "Hotel deleted";
        }
        catch (Exception e) {
            return "Hotel Not found";
        }
    }
}
