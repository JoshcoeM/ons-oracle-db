package com.manifestcorp.onsoracledb.dao;

import com.manifestcorp.onsdomain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    public void insertOrder(Order order);
}
