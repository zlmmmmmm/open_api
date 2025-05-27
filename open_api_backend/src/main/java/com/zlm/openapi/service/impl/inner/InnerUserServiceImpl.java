package com.zlm.openapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlm.openapi.common.ErrorCode;
import com.zlm.openapi.exception.BusinessException;
import com.zlm.openapi.mapper.UserMapper;
import com.zlm.openapi.service.UserService;
import com.zlm.zlmapicommon.model.entity.User;
import com.zlm.zlmapicommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {
    @Resource
    private UserService userService;

    @Override
    public User getInvokeUser(String accessKey) {
        if(StringUtils.isAnyBlank(accessKey)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        return userService.getBaseMapper().selectOne(queryWrapper);
    }
}
