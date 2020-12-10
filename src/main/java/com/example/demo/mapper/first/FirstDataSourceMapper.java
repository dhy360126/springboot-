package com.example.demo.mapper.first;

import com.example.demo.entity.CommodityVo;

import java.util.List;

public interface FirstDataSourceMapper {

    Integer insertFirstUser(CommodityVo commodityVo);

    List<CommodityVo> findFirstData();

}
