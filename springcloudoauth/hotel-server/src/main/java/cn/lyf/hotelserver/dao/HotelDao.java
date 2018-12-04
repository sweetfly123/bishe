package cn.lyf.hotelserver.dao;

import cn.lyf.hotelserver.entity.Hotel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Title:  HotelDao
 * @Param:  * @param null
 * @Description: hotelDao层接口
 * @author: DIC.sweetlfy
 * @date: 2018/11/19 9:43
 * @version: V1.0
 */
@Repository
public interface HotelDao {
    //通过房间号查询
    Hotel getHotelByHotelId(String hotelId);
    //查询所有房间信息
    List<Hotel> findAllHotels();
    //通过UserName查询该用户的房间
    List<Hotel> getHotelByUserName(String userName);
    //增加房间
    int addHotel(Hotel hotel);
    //更新房间信息
    //int updateHotel(@Param("userId") String userId, @Param("roomId") String roomId);
    int updateHotel(Hotel hotel);
}
