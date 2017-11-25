package com.mfkcel.model;

public class Equipment {
	private Integer id;
	private String name;
	private String no;
	private Integer typeId;
	private Integer state; //设备状态：1.正常 2.维修状态  3.报废状态
	private String stateStr;
	private String remark; //备注
	
	public String getStateStr(){
		if(this.state == 1) {
			return "正常";
		}
		
		if(this.state == 2) {
			return "维修中";
		}
		
		if(this.state == 3) {
			return "报废";
		}
		return "未更新设备状态";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
