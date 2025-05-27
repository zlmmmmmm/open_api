package com.zlm.zlmapicommon.service;


import com.zlm.zlmapicommon.model.entity.InterfaceInfo;

/**
* @author admin
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2025-04-23 11:02:16
*/
public interface InnerInterfaceInfoService {
    InterfaceInfo getInterfaceInfo(String path,String method);
}
