package com.acom.services.sv;

import com.acom.entities.model.BsCacheTable;

import java.util.List;

/**
 *
 */
public interface IBsCacheTableService {

    /**
     * 查询所有生效的缓存表
     *
     * @param status
     * @return List
     * @author zhaojy
     * @createTime 2017-06-06
     */
    public List<BsCacheTable> getCacheTables(int status);
}
