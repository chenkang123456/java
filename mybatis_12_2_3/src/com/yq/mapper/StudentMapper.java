package com.yq.mapper;

import java.util.List;
import java.util.Map;

import com.yq.pojo.IdPojo;
import com.yq.pojo.StudentPojo;

public interface StudentMapper {
	//根据id查，如果没有id，查全部
	List<StudentPojo> selectById(Integer id);
	//根据id，name，age查，哪个不为空根据哪个查
//	List<StudentPojo> selectByIdNameAge(StudentPojo student );
	//id不为空按id查，name不为空按name查
	List<StudentPojo> selectByIdNameAge2(StudentPojo student );
	//数组
	List<StudentPojo> selectByIds(Integer[] ids );
	//集合
	List<StudentPojo> selectByIds2(List<Integer> ids );
	
	List<StudentPojo> selectByIds31(IdPojo ids);
	
	List<StudentPojo> selectByIds32(IdPojo ids);
	
	List<StudentPojo> selectByNameLike(String name);
	
	List<StudentPojo> selectOrder(String col);
}
