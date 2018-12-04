package cn.lyf.hotelserver.service;

import cn.lyf.hotelserver.dao.HotelDao;
import cn.lyf.hotelserver.entity.Hotel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Resource
    private HotelDao hotelDao;

    @Override
    public Hotel getHotelByHotelId(String hotelId) {
        return hotelDao.getHotelByHotelId(hotelId);
    }

    @Override
    public List<Hotel> findAllHotels() {
        return hotelDao.findAllHotels();
    }

    @Override
    public List<Hotel> getHotelByUserName(String userName) {
        return hotelDao.getHotelByUserName(userName);
    }

    @Override
    public int addHotel(Hotel hotel) {
        return hotelDao.addHotel(hotel);
    }

    @Override
    public int updateHotel(String userId, String roomId) {
        Hotel hotel = new Hotel();
        hotel.setUserId(userId);
        hotel.setRoomId(roomId);
        hotel.setBook(true);
        return hotelDao.updateHotel(hotel);
    }
}
