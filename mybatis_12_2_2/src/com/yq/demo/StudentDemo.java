package com.yq.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.JdbcType;

import com.yq.mapper.StudentMapper;
import com.yq.pojo.IdPojo;
import com.yq.pojo.StudentPojo;

public class StudentDemo {
	public static void main(String[] args) throws IOException {
		//获得核心配置文件
		InputStream config = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//获得工厂
		SqlSessionFactory factory=builder.build(config);
		//获得SQLSession
		SqlSession session=factory.openSession();
		
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);

//		System.out.println(studentMapper.selectById(null));
		
		StudentPojo student = new StudentPojo();
//		student.setId(2);
//		studentMapper.selectByIdNameAge(student);
//		student.setName("李芳");
//		studentMapper.selectByIdNameAge(student);
//		student.setAge(22);
//		studentMapper.selectByIdNameAge(student);
//		student.setAddress("上海");
//		studentMapper.selectByIdNameAge(student);
		
		System.out.println("=========================================");
		
//		student.setId();
//		studentMapper.selectByIdNameAge2(student);
//		student.setName(null);
//		studentMapper.selectByIdNameAge2(student);
//		student.setAge(22);
//		studentMapper.selectByIdNameAge2(student);
//		student.setAddress(null);
//		studentMapper.selectByIdNameAge2(student);
//		System.out.println(studentMapper.selectByIds(new Integer[]{1,2,3,4}));
//		
//		System.out.println(studentMapper.selectByIds2(Arrays.asList(1,2,3)));
		
		IdPojo ids = new IdPojo();
		ids.setIds1(new Integer[] {1,2,3});
		ids.addIds2(4);
		ids.addIds2(5);
		ids.addIds2(6);
		System.out.println(studentMapper.selectByIds31(ids));
		System.out.println(studentMapper.selectByIds32(ids));
		
		session.commit();
		session.close();
		
	}
}
