package com.zlm.openapi.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.zlm.openapi.model.dto.interfaceInfo.InterfaceInfoQueryRequest;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zlm.zlmapicommon.model.entity.UserInterfaceInfo;

/**
* @author admin
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2025-05-19 19:42:56
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    boolean invokeCount(long interfaceInfoId,long userId);

    Wrapper<UserInterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest);
}
