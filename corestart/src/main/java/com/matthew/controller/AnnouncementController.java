package com.matthew.controller;

import com.matthew.Utils.ReturnResultUtils;
import com.matthew.entity.Announcement;
import com.matthew.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ltj
 * @Description:
 * @Date: Create in 16:37 2019/11/14
 */
@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

   @Autowired
   private AnnouncementService announcementService;


    /**
     * 保存公告信息
     * @param announcement
     * @return  成功返回 新的list
     *          失败返回 错误码
     *
     */
    @RequestMapping("/save")
   public ReturnResultUtils saveAnnoucement(@RequestBody Announcement announcement){
       return announcementService.saveAnnouncement(announcement);

   }

    /**
     * 删除公告信息
     * @param annouid
     * @return  成功 返回新的list
     */
   public ReturnResultUtils deleteAnnoucement(@RequestParam String annouid){
      return  announcementService.deleteAnnouncement(annouid);
   }

    /**
     * 查询公告信息
     * @return 成功 返回新的list
     */
   public ReturnResultUtils findList(){
       return  announcementService.findList();
   }

}
