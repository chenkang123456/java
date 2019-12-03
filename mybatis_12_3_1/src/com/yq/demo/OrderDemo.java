package com.yq.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yq.mapper.OrderMapper;
import com.yq.mapper.UserMapper;
import com.yq.pojo.OrderDetailPojo;
import com.yq.pojo.OrderPojo;
import com.yq.pojo.UserPojo;

public class OrderDemo {
	public static void main(String[] args) throws IOException {
		//获得核心配置文件
		InputStream config = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//获得工厂
		SqlSessionFactory factory=builder.build(config);
		//获得SQLSession
		SqlSession session=factory.openSession();
		
//		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
//		OrderPojo order = orderMapper.selectById(1);
//		System.out.println(order);
//		System.out.println(order.getUser());
		
//		OrderPojo order2 = orderMapper.selectById2(2);
//		System.out.println(order2);
//		System.out.println(order2.getUser());
//		System.out.println(order2.getDetails().size());
//		System.out.println(order2.getDetails());
		System.out.println("====================================");
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<UserPojo> users = userMapper.selectAll();
		for (UserPojo u : users) {
			System.out.println(u);
			List<OrderPojo> orders = u.getOrders();
			for (OrderPojo o : orders) {
				System.out.println("\t"+o);
				List<OrderDetailPojo> details = o.getDetails();
				for (OrderDetailPojo od : details) {
					System.out.println("\t\t"+od);
					System.out.println("\t\t\t"+od.getItem());
					
				}
			}
		}
		
		session.commit();
		session.close();
		
	}
}
