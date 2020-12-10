package com.example.demo.mapper.second;

import com.example.demo.entity.UserVo;

import java.util.List;

public interface SecondDataSourceMapper {
    Integer insertSecondUser(UserVo userVO);

    List<UserVo> findSecondData();
}
