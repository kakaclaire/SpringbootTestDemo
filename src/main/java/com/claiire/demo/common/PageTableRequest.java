package com.claiire.demo.common;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import sun.awt.SunHints;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈分页请求对象〉
 *
 * @author Claire
 * @create 2021/3/4
 * @since 1.0.0
 */
@Data
public class PageTableRequest<Dto extends BaseDto> implements Serializable {
    public static final long serilVersionUID = 11L;
    @ApiModelProperty(value = "页码", required = true, example = "1")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "每页数据量", required = true, example = "10")
    private Integer pageSize = 10;
    @ApiModelProperty(value = "特定查询参数", required = true, example = "status=1")
    private Dto params;
}
