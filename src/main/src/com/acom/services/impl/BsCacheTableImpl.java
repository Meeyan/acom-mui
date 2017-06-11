package com.acom.services.impl;

import com.acom.entities.mapper.BsCacheTableMapper;
import com.acom.entities.model.BsCacheTable;
import com.acom.entities.model.BsCacheTableExample;
import com.acom.services.sv.IBsCacheTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台用户SV
 *
 * @author zhaojy
 * @createTime 2017-06-05
 */
@Service(value = "bsCacheTable")
public class BsCacheTableImpl implements IBsCacheTableService {

    @Autowired
    private BsCacheTableMapper tableMapper;

    public List<BsCacheTable> getCacheTables(int status) {
        BsCacheTableExample example = new BsCacheTableExample();
        BsCacheTableExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        return tableMapper.selectByExample(example);
    }
}
