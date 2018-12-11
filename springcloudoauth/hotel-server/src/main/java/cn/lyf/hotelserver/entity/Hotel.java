package cn.lyf.hotelserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: Hotel
 * @Description: 酒店实体类
 * @author: DIC.lyf
 * @date: 2018/12/7 11:43
 * @Return:
 * @version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    /**
     房间号
     */
    private String roomId;
    /**
     类型
     */
    private int roomType;
    /**
     价格
     */
    private double roomPrice;
    /**
     图片路径
     */
    private String roomPicturePath;
    /**
     是否预订
     */
    private boolean booked;
    /**
     订房用户id
     */
    private String userId;
}
