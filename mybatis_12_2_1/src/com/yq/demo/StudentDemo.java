package com.yq.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.JdbcType;

import com.yq.mapper.StudentMapper;
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
		StudentMapper studentMapper =  session.getMapper(StudentMapper.class);
//		System.out.println(studentMapper.selectCount());
//		
//		System.out.println(studentMapper.selectById(2));
//		
//		System.out.println(studentMapper.selectById(3));
//		
//		System.out.println(studentMapper.selectAll());
//		
		System.out.println(studentMapper.selectByIdResultMap(3));
		
		StudentPojo spj= new StudentPojo();
		spj.setName("张三丰");
		spj.setAge(400);
		spj.setAddress("武当山");
//		System.out.println(studentMapper.insertStudent(spj));
		System.out.println(studentMapper.insertStudent2(spj));
		System.out.println(spj);
		//System.out.println(studentMapper.deleteStudent(4));
		session.commit();
		session.close();
		
	}
}
