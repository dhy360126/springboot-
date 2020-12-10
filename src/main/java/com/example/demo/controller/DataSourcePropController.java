package com.example.demo.controller;

import com.example.demo.entity.CommodityVo;
import com.example.demo.entity.UserVo;
import com.example.demo.service.IDataSourcePropService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class DataSourcePropController {

    @Autowired
    private IDataSourcePropService dataSourcePropService;

    /**
     * 向MYSQL_FIRST插入数据
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/firstInsert")
    public Integer firstInsert(String userName, String password) {
        CommodityVo commodityVo = new CommodityVo();
        commodityVo.setUserName(userName);
        commodityVo.setPassWord(password);
        return dataSourcePropService.insertFirstUserLst(commodityVo);
    }

    /**
     * 向MYSQL_SECOND插入数据
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/secondInsert")
    public Integer secondInsert(String userName, String password) {
        UserVo userVO = new UserVo();
        userVO.setUserName(userName);
        userVO.setPassWord(password);
        return dataSourcePropService.insertSecondUserLst(userVO);
    }

    /**
     * 查询MYSQL_FIRST数据
     *
     * @return
     */
    @RequestMapping("/firstPropSelect")
    public List<CommodityVo> findFirstData() {
        return dataSourcePropService.findFirstData();
    }

    /**
     * 查询MYSQL_SECOND数据
     *
     * @return
     */
    @RequestMapping("/secondPropSelect")
    public List<UserVo> findSecondData() {
        return dataSourcePropService.findSecondData();
    }

}
