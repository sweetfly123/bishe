package cn.lyf.hotelserver.service.Impl;

import cn.lyf.hotelserver.dao.HotelDao;
import cn.lyf.hotelserver.entity.HotelDO;
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
    public HotelDO getHotelByHotelId(String hotelId) {
        return hotelDao.getHotelByHotelId(hotelId);
    }

    @Override
    public List<HotelDO> findAllHotels() {
        return hotelDao.findAllHotels();
}

    @Override
    public List<HotelDO> getHotelByUserName(String userName) {
        return hotelDao.getHotelByUserName(userName);
    }

    @Override
    public int addHotel(HotelDO hotelDO) {
        return hotelDao.addHotel(hotelDO);
    }

    @Override
    public int updateHotel(String userId, String roomId) {
        HotelDO hotelDO = new HotelDO();
        hotelDO.setUserId(userId);
        hotelDO.setRoomId(roomId);
        hotelDO.setBooked(true);
        return hotelDao.updateHotel(hotelDO);
    }
}
