package com.example.demo.service.impl;

import com.example.demo.entity.CommodityVo;
import com.example.demo.entity.UserVo;
import com.example.demo.mapper.first.FirstDataSourceMapper;
import com.example.demo.mapper.second.SecondDataSourceMapper;
import com.example.demo.service.IDataSourcePropService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class DataSourcePropServiceImpl implements IDataSourcePropService {
    /**
     * 注入first mapper层, 连接MYSQL_FIRST数据库操作
     */

    @Autowired
    private FirstDataSourceMapper firstDataSourceMapper;

    /**
     * 注入second mapper层, 连接MYSQL_SECOND数据库操作
     */
    @Autowired
    private SecondDataSourceMapper secondDataSourceMapper;

    @Override
    public Integer insertFirstUserLst(CommodityVo commodityVo) {
        return firstDataSourceMapper.insertFirstUser(commodityVo);
    }

    @Override
    public Integer insertSecondUserLst(UserVo userVO) {
        return secondDataSourceMapper.insertSecondUser(userVO);
    }

    @Override
    public List<CommodityVo> findFirstData() {
        return firstDataSourceMapper.findFirstData();
    }

    @Override
    public List<UserVo> findSecondData() {
        return secondDataSourceMapper.findSecondData();
    }
}
