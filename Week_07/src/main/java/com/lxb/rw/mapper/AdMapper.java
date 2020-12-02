package com.lxb.rw.mapper;

import com.lxb.rw.entity.Ad;

/**
 * @author lixiaobing
 * @date 2020-12-03 01:23
 * @Description:
 */
public interface AdMapper {
    /**
     * 增加广告
     *
     * @tags return void
     */
    int add (Ad ad);

    /**
     * 根据广告Id查询广告 供管理平台使用
     *
     * @tags @param adId
     * @tags @return
     * return Ad
     */
    Ad queryAdById (String advertisementId);

}
