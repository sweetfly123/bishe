package cn.lyf.hotelserver.service;


import cn.lyf.hotelserver.entity.Hotel;

import java.util.List;

public interface HotelService {
    //通过房间号查询
    Hotel getHotelByHotelId(String hotelId);
    //查询所有房间信息
    List<Hotel> findAllHotels();
    //通过UserId查询该用户的房间
    List<Hotel> getHotelByUserName(String userName);
    //增加房间
    int addHotel(Hotel hotel);
    //更新房间信息
    int updateHotel(String userId, String roomId);
}
