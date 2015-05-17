package onmobile.atlantis.mms.hibernateModel.binary;

import java.io.Serializable;
import java.util.Date;

import org.omg.CORBA.PRIVATE_MEMBER;

public class CpRightsMatrixMuzikMind implements Serializable {

	private String binaryMapId;
	private Date created;
	private String createdBy;
	private Date lastModified;
	private String lastModifiedBy;
	
	private Date bsnlStartDate;
	private Date bsnlEndDate;
	private String bsnlState ;	
	
	public String getBinaryMapId() {
		return binaryMapId;
	}
	public void setBinaryMapId(String binaryMapId) {
		this.binaryMapId = binaryMapId;
	}	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getBsnlStartDate() {
		return bsnlStartDate;
	}
	public void setBsnlStartDate(Date bsnlStartDate) {
		this.bsnlStartDate = bsnlStartDate;
	}
	public Date getBsnlEndDate() {
		return bsnlEndDate;
	}
	public void setBsnlEndDate(Date bsnlEndDate) {
		this.bsnlEndDate = bsnlEndDate;
	}
	public String getBsnlState() {
		return bsnlState;
	}
	public void setBsnlState(String bsnlState) {
		this.bsnlState = bsnlState;
	}	
}	