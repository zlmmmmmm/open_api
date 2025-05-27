package com.zlm.zlmapicommon.service;


import com.zlm.zlmapicommon.model.entity.UserInterfaceInfo;

/**
* @author admin
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2025-05-19 19:42:56
*/
public interface InnerUserInterfaceInfoService {
    boolean invokeCount(long interfaceInfoId,long userId);
    UserInterfaceInfo getUserInterfaceInfo(long interfaceInfoId,long userId);
}
