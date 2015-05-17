package onmobile.atlantis.mms.hibernateModel.binary;

import java.io.Serializable;
import java.util.Date;

public class MMBinaryMap implements Serializable {
    
	private String binaryMapId;
    private String whSongId;
    private String binaryId;
    private Date created;
    private String createdBy;
    private Date lastModified;
    private String lastModifiedBy;
    private Date stateOn;
    private String stateBy;
    private String stateName;
    private String stateReason;
    private String callFromTrigger;
    private String holderContentTypeName;
    private String holderContentSubTypeId;
	
    public String getBinaryMapId() {
		return binaryMapId;
	}
	public void setBinaryMapId(String binaryMapId) {
		this.binaryMapId = binaryMapId;
	}
	public String getWhSongId() {
		return whSongId;
	}
	public void setWhSongId(String whSongId) {
		this.whSongId = whSongId;
	}
	public String getBinaryId() {
		return binaryId;
	}
	public void setBinaryId(String binaryId) {
		this.binaryId = binaryId;
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
	public Date getStateOn() {
		return stateOn;
	}
	public void setStateOn(Date stateOn) {
		this.stateOn = stateOn;
	}
	public String getStateBy() {
		return stateBy;
	}
	public void setStateBy(String stateBy) {
		this.stateBy = stateBy;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateReason() {
		return stateReason;
	}
	public void setStateReason(String stateReason) {
		this.stateReason = stateReason;
	}
	public String getCallFromTrigger() {
		return callFromTrigger;
	}
	public void setCallFromTrigger(String callFromTrigger) {
		this.callFromTrigger = callFromTrigger;
	}
	public String getHolderContentTypeName() {
		return holderContentTypeName;
	}
	public void setHolderContentTypeName(String holderContentTypeName) {
		this.holderContentTypeName = holderContentTypeName;
	}
	public String getHolderContentSubTypeId() {
		return holderContentSubTypeId;
	}
	public void setHolderContentSubTypeId(String holderContentSubTypeId) {
		this.holderContentSubTypeId = holderContentSubTypeId;
	}    
}
