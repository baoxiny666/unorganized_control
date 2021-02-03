package com.lhtg.unorganized_control.utils;

import com.github.pagehelper.PageInfo;
import com.lhtg.unorganized_control.entity.PageResult;
import org.apache.poi.ss.formula.functions.T;

public class PageUtils {
    public static PageResult getPageResult(T t, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
