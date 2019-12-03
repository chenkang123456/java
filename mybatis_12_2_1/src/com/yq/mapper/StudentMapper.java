package com.yq.mapper;

import java.util.List;
import java.util.Map;

import com.yq.pojo.StudentPojo;

public interface StudentMapper {
	
	int selectCount();
	
	Map<String,Object> selectById(Integer id);
	
	List<StudentPojo> selectAll();
	
	//查询的列起别名，与数据库列名不一致
	StudentPojo selectByIdResultMap(Integer id);
	
	int insertStudent(StudentPojo student);
	
	int insertStudent2(StudentPojo student);
	
//	int deleteStudent(Integer id);

}
