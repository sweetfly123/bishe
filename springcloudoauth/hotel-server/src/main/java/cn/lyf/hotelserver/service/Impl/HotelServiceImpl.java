package cn.lyf.hotelserver.service.Impl;

import cn.lyf.hotelserver.dao.HotelDao;
import cn.lyf.hotelserver.entity.Hotel;
import cn.lyf.hotelserver.service.HotelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @method: HotelServiceImpl
 * @Description: 酒店业务实现类
 * @author: DIC.lyf
 * @date: 2018/12/7 11:52
 * @Return:
 * @version: V1.0
 */
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
        hotel.setBooked(true);
        return hotelDao.updateHotel(hotel);
    }
}
