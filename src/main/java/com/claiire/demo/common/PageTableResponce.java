package com.claiire.demo.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈分页响应对象〉
 *
 * @author Claire
 * @create 2021/3/4
 * @since 1.0.0
 */
@Data
public class PageTableResponce<T> implements Serializable {
    public static final long serialVersionUID=1121L;
    private Integer recordsTotal;
    private List<T> data;
}
