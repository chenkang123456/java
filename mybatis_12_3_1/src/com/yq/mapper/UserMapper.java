package com.yq.mapper;

import java.util.List;

import com.yq.pojo.UserPojo;

public interface UserMapper {
	List<UserPojo> selectAll();
}
