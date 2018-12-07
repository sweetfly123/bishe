package cn.lyf.hotelserver.controller;

import cn.lyf.hotelserver.entity.Hotel;
import cn.lyf.hotelserver.service.HotelService;
import cn.lyf.hotelserver.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * @Title:  HotelController
 * @Description: 酒店房间接口
 * @author: DIC.lyf
 * @date: 2018/12/7 11:31
 * @Return:
 * @version: V1.0
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final ResourceLoader resourceLoader;

    @Autowired
    public HotelController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;
    @Resource
    private HotelService hotelService;

    /**
     * 通过房间号查询
     * @param hotelId
     * @return
     */
    @RequestMapping(value = "/hotel/{hotelId}",method = RequestMethod.GET)
    public Hotel getHotelByHotelId(@PathVariable("hotelId") String hotelId){
         Hotel hotel =  hotelService.getHotelByHotelId(hotelId);
        return hotel;
    }
    /**
     * 查询所有房间信息
     * @param
     * @return
     */
    @RequestMapping(value = "/hotel",method = RequestMethod.GET)
    public List<Hotel> findAllHotels(){
         List<Hotel> list = hotelService.findAllHotels();
         return list;
    }

    /**
     * 根据用户名查询房间
     * @param userName
     * @return
     */
    @RequestMapping(value = "/hotel/userName/{userName}",method = RequestMethod.GET)
    public List<Hotel> getHotelByUserName(@PathVariable("userName") String userName){
        return hotelService.getHotelByUserName(userName);
    }

    /**
     * 增加房间
     * @param file
     * @param hotel
     * @return
     */
    @RequestMapping(value = "/hotel",method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public int addHotel(MultipartFile file, Hotel hotel ){
        //String localPath =getRequest().getServletContext().getRealPath("/static");
        // 要上传的目标文件存放路径
//        File filedir = new File(path);
//        if (!filedir.exists()) {
//            filedir.mkdirs();
//        }
        //String localPath = "D:/DevelopPhotos";
        // 上传成功或者失败的提示
        String msg = "";
        if (FileUtils.upload(file, path, file.getOriginalFilename())){
            // 上传成功，给出页面提示
            msg = "上传成功！";
        }else {
            msg = "上传失败！";
        }
        String fileName = file.getOriginalFilename();
        hotel.setRoomPicturePath(fileName);
       // hotel.setRoomPicturePath(resourceLoader.getResource("file:" + path + fileName));
        hotelService.addHotel(hotel);
        return 1;
    }

    @RequestMapping(value = "/hotel/room/{roomId}/user/{userId}",method = RequestMethod.PUT)
    public int bookHotel(@PathVariable("roomId") String roomId,@PathVariable("userId") String userId){
        int result = hotelService.updateHotel(userId,roomId);
        return result;
    }
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes)      RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

}
