package com.zlm.openapi.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlm.openapi.model.dto.interfaceInfo.InterfaceInfoAddRequest;
import com.zlm.openapi.model.dto.interfaceInfo.InterfaceInfoQueryRequest;
import com.zlm.openapi.model.dto.post.PostQueryRequest;
import com.zlm.openapi.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zlm.openapi.model.entity.Post;

import javax.servlet.http.HttpServletRequest;

/**
* @author admin
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2025-04-23 11:02:16
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest);
}
