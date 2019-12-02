package com.matthew.controller;

import com.matthew.Utils.ReturnResultUtils;
import com.matthew.entity.Announcement;
import com.matthew.service.AnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "描述")
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
    @ApiOperation(value = "保存公告信息",notes = "用户发布公告")
    @ApiImplicitParams(
        @ApiImplicitParam(name="announcement",value = "公告实体",required = true,dataType = "Announcement" ,paramType="query")
    )
    @RequestMapping("/save")
   public ReturnResultUtils saveAnnoucement(@RequestBody Announcement announcement){
       return announcementService.saveAnnouncement(announcement);

   }

    /**
     * 删除公告信息
     * @param annouid
     * @return  成功 返回新的list
     */
    @ApiOperation(value = "删除公告信息",notes = "删除需要去掉的公告信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "annouid",value = "公告id",required = true,dataType = "String",paramType ="query" )
    )
   public ReturnResultUtils deleteAnnoucement(@RequestParam String annouid){
      return  announcementService.deleteAnnouncement(annouid);
   }

    /**
     * 查询公告信息
     * @return 成功 返回新的list
     */
    @ApiOperation(value = "查询所有的公告信息",notes = "显示公告信息")
   public ReturnResultUtils findList(){
       return  announcementService.findList();
   }

}
