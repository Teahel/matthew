package com.matthew.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matthew.Utils.ReturnResultUtils;
import com.matthew.entity.Announcement;

/**
 * @Author: ltj
 * @Description:
 * @Date: Create in 16:40 2019/11/14
 */
public interface AnnouncementService extends IService<Announcement> {

    /**
     * 保存公告信息
     * @param announcement
     * @return  成功返回 新的list
     *          失败返回 错误码
     *
     */
    ReturnResultUtils saveAnnouncement(Announcement announcement);

    /**
     * 删除公告
     * @return  成功返回 新的list
     *          失败返回 错误码
     */
    ReturnResultUtils deleteAnnouncement(String announceid);

    /**
     * 查询公告
     * @return  成功返回 新的list
     *          失败返回 错误码
     */
    ReturnResultUtils findList();

}
