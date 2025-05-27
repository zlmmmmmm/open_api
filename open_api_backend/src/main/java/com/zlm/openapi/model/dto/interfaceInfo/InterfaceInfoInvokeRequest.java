package com.zlm.openapi.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 接口调用请求
 *
 * @TableName product
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户请求参数
     */
    private Map<String, Object> userRequestParams;

    private static final long serialVersionUID = 1L;
}
