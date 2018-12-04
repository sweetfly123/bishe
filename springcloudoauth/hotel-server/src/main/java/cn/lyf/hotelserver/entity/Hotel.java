package cn.lyf.hotelserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private boolean isBook;
    /**
     订房用户id
     */
    private String userId;
}
