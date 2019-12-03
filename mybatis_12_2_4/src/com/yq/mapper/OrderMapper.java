package com.yq.mapper;

import com.yq.pojo.OrderPojo;

public interface OrderMapper {
	//查询一个订单，同时查出下单用户
	OrderPojo selectById(Integer id);
	//查询一个订单，同时查出明细集合
	OrderPojo selectById2(Integer id);
	
}
