package com.mfkcel.model;

import java.util.Date;

public class Repair {
	private Integer id;
	private Integer equipmentId;
	private String equiptName; //�豸��
	private String equiptTypeName; //�豸������
	private String userman; //������Ա
	private String repairmen; //ά����Ա
	private Date repairTime;  //����ʱ��
	private Date finishTime; //�������ʱ��
	private Integer state;  //�����豸״̬ : 1. ά�޳ɹ� 2.�豸����
	private Integer finishState; //�Ƿ����  1.δ����״̬ 2.������� 3. ������
	
	
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
