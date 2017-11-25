package com.mfkcel.model;

public class Equipment {
	private Integer id;
	private String name;
	private String no;
	private Integer typeId;
	private Integer state; //�豸״̬��1.���� 2.ά��״̬  3.����״̬
	private String stateStr;
	private String remark; //��ע
	
	public String getStateStr(){
		if(this.state == 1) {
			return "����";
		}
		
		if(this.state == 2) {
			return "ά����";
		}
		
		if(this.state == 3) {
			return "����";
		}
		return "δ�����豸״̬";
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
