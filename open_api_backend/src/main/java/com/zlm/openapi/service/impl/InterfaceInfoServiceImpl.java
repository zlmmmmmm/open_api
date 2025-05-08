package com.zlm.openapi.service.impl;
import java.util.Date;
import java.util.List;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlm.openapi.common.ErrorCode;
import com.zlm.openapi.constant.CommonConstant;
import com.zlm.openapi.exception.BusinessException;
import com.zlm.openapi.exception.ThrowUtils;
import com.zlm.openapi.model.dto.interfaceInfo.InterfaceInfoQueryRequest;
import com.zlm.openapi.model.entity.InterfaceInfo;
import com.zlm.openapi.model.entity.Post;
import com.zlm.openapi.service.InterfaceInfoService;
import com.zlm.openapi.mapper.InterfaceInfoMapper;
import com.zlm.openapi.utils.SqlUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.title;

/**
* @author admin
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2025-04-23 11:02:16
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService{

    /**
     * 参数校验
     * @param interfaceInfo
     * @param add
     */
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if(interfaceInfo==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        String name = interfaceInfo.getName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        String method = interfaceInfo.getMethod(); Long userId = interfaceInfo.getUserId();

        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(name,description,url,requestHeader,responseHeader,method), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if(StringUtils.isNotBlank(name) && name.length() > 50){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"名称过长");
        }

    }

    @Override
    public QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        if (interfaceInfoQueryRequest == null) {
            return queryWrapper;
        }

        Long id = interfaceInfoQueryRequest.getId();
        String name = interfaceInfoQueryRequest.getName();
        String description = interfaceInfoQueryRequest.getDescription();
        String url = interfaceInfoQueryRequest.getUrl();
        String requestHeader = interfaceInfoQueryRequest.getRequestHeader();
        String responseHeader = interfaceInfoQueryRequest.getResponseHeader();
        Integer status = interfaceInfoQueryRequest.getStatus();
        String method = interfaceInfoQueryRequest.getMethod();
        int current = interfaceInfoQueryRequest.getCurrent();
        int pageSize = interfaceInfoQueryRequest.getPageSize();
        String sortField = interfaceInfoQueryRequest.getSortField();
        String sortOrder = interfaceInfoQueryRequest.getSortOrder();

        // 拼接查询条件
        // 这里写的不是很熟练，mysql需要加强一下，mysql、mybatis 和 plus
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.like("name", name);
        }
        if (StringUtils.isNotBlank(description)) {
            queryWrapper.like("description", description);
        }
        if (StringUtils.isNotBlank(url)) {
            queryWrapper.like("url", url);
        }
        if (StringUtils.isNotBlank(requestHeader)) {
            queryWrapper.like("requestHeader", requestHeader);
        }
        if (StringUtils.isNotBlank(responseHeader)) {
            queryWrapper.like("responseHeader", responseHeader);
        }
        if (status != null) {
            queryWrapper.eq("status", status);
        }
        if (StringUtils.isNotBlank(method)) {
            queryWrapper.eq("method", method);
        }
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }
}




