package com.example.demo.service;

import com.example.demo.entity.CommodityVo;
import com.example.demo.entity.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IDataSourcePropService {

    /**
     * 保存数据-MYSQL_FIRST
     *
     * @param
     * @return
     */
    Integer insertFirstUserLst(CommodityVo commodityVo);

    /**
     * 保存数据-MYSQL_SECOND
     *
     * @param userVO
     * @return
     */
    Integer insertSecondUserLst(UserVo userVO);

    /**
     * 查询数据-MYSQL_FIRST
     *
     * @return
     */
    List<CommodityVo> findFirstData();

    /**
     * 查询数据-MYSQL_SECOND
     *
     * @return
     */
    List<UserVo> findSecondData();
}
