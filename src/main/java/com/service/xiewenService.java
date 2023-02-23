package com.service;

import com.pojo.xiewen;

import java.util.List;

public interface xiewenService {
    List<xiewen> selectall();
    void add(xiewen xiewen1);
    void deleteById(String xinwen);
    void updateById(xiewen xiewen);
    List<xiewen>tiaocha(xiewen xiewen1);

}
