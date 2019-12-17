package com.matthew.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matthew.Utils.ReturnResultUtils;
import com.matthew.entity.Announcement;
import com.matthew.mapper.AnnouncementMapper;
import com.matthew.service.AnnouncementService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ltj
 * @Description:
 * @Date: Create in 16:40 2019/11/14
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper,Announcement> implements AnnouncementService {

    /**
     * 保存公告信息
     * @param announcement
     * @return  成功返回 新的list
     *          失败返回 错误码
     */
    @Override
    public ReturnResultUtils saveAnnouncement(Announcement announcement) {
        ReturnResultUtils returnResultUtils = new ReturnResultUtils();
        boolean flag = this.save(announcement);
        if(flag){
         return  returnResultUtils.putList(this.list());
        }
        return ReturnResultUtils.error(500,"保存公告失败");
    }

    /**
     * 删除公告
     * @param --announcement
     * @return  成功返回 新的list
     *          失败返回 错误码
     */
    @Override
    public ReturnResultUtils deleteAnnouncement(String annouid) {
        ReturnResultUtils returnResultUtils = new ReturnResultUtils();
        boolean flag = this.removeById(annouid);
        if(flag){
            return  returnResultUtils.putList(this.list());
        }
        return ReturnResultUtils.error(500,"删除公告失败");
    }

    /**
     * 查询公告
     * @return  成功返回 新的list
     *          失败返回 错误码
     */
    public ReturnResultUtils findList(){
        ReturnResultUtils returnResultUtils = new ReturnResultUtils();
        List<Announcement> list = this.list();
        return  returnResultUtils.putList(list);
    }

}
