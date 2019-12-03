package com.yq.demo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yq.mapper.OrderMapper;
import com.yq.pojo.OrderPojo;

public class OrderDemo {
	public static void main(String[] args) throws IOException {
		//获得核心配置文件
		InputStream config = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//获得工厂
		SqlSessionFactory factory=builder.build(config);
		//获得SQLSession
		SqlSession session=factory.openSession();
		
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
//		OrderPojo order = orderMapper.selectById(1);
//		System.out.println(order);
//		System.out.println(order.getUser());
		
		OrderPojo order2 = orderMapper.selectById2(2);
		System.out.println(order2);
		System.out.println(order2.getUser());
		System.out.println(order2.getDetails().size());
		System.out.println(order2.getDetails());
		session.commit();
		session.close();
		
	}
}
