package uz.pdp.vazifa_1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.vazifa_1.entity.Hotel;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Integer id;

    private Integer number;

    private Integer floor;

    private String size;

    private Integer hotelId;
}
