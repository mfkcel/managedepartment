package com.mfkcel.model;

import java.util.Date;

public class Repair {
	private Integer id;
	private Integer equipmentId;
	private String equiptName; //设备名
	private String equiptTypeName; //设备类型名
	private String userman; //报修人员
	private String repairmen; //维修人员
	private Date repairTime;  //报修时间
	private Date finishTime; //处理完成时间
	private Integer state;  //最终设备状态 : 1. 维修成功 2.设备报废
	private Integer finishState; //是否完成  1.未处理状态 2.处理完成 3. 处理中
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getUserman() {
		return userman;
	}
	public void setUserman(String userman) {
		this.userman = userman;
	}
	public String getRepairmen() {
		return repairmen;
	}
	public void setRepairmen(String repairmen) {
		this.repairmen = repairmen;
	}
	public Date getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(Date repairTime) {
		this.repairTime = repairTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getFinishState() {
		return finishState;
	}
	public void setFinishState(Integer finishState) {
		this.finishState = finishState;
	}
	public String getEquiptName() {
		return equiptName;
	}
	public void setEquiptName(String equiptName) {
		this.equiptName = equiptName;
	}
	public String getEquiptTypeName() {
		return equiptTypeName;
	}
	public void setEquiptTypeName(String equiptTypeName) {
		this.equiptTypeName = equiptTypeName;
	}
	
}
