package com.yq.pojo;

import java.util.ArrayList;
import java.util.List;

public class IdPojo {
	private Integer[] ids1;
	private List<Integer> ids2;
	public IdPojo() {
		ids2=new ArrayList<Integer>();
	}
	public Integer[] getIds1() {
		return ids1;
	}
	public void setIds1(Integer[] ids1) {
		this.ids1 = ids1;
	}
	public List<Integer> getIds2() {
		return ids2;
	}
	public void setIds2(List<Integer> ids2) {
		this.ids2 = ids2;
	}
	public void addIds2(Integer id) {
		this.ids2.add(id);
	}
}
