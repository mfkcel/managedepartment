package com.mfkcel.model;

public class Department {
	private Integer id;
	private String departName;
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", departName=" + departName + ", remark=" + remark + "]";
	}
	
	
}
