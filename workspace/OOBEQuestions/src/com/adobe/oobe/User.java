package com.adobe.oobe;

import java.util.List;

public class User {
	
	public enum NotificationType {
		GROUP_CHANGED;
	} 
	
	private NotificationType notificationType;
	private String enrollingEntity;
	private List <String> groupsToAssign;
	private String member;
	private List <String> groupsUnassigned;
	
	public NotificationType getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}
	public String getEnrollingEntity() {
		return enrollingEntity;
	}
	public void setEnrollingEntity(String enrollingEntity) {
		this.enrollingEntity = enrollingEntity;
	}
	public List<String> getGroupsToAssign() {
		return groupsToAssign;
	}
	public void setGroupsToAssign(List<String> groupsToAssign) {
		this.groupsToAssign = groupsToAssign;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public List<String> getGroupsUnassigned() {
		return groupsUnassigned;
	}
	public void setGroupsUnassigned(List<String> groupsUnassigned) {
		this.groupsUnassigned = groupsUnassigned;
	}
	
	@Override
	public String toString() {
		return "User [notificationType=" + notificationType + ", enrollingEntity=" + enrollingEntity + ", groupsToAssign=" + groupsToAssign + ", member=" + member + ", groupsUnassigned="
				+ groupsUnassigned + "]";
	}	
}
