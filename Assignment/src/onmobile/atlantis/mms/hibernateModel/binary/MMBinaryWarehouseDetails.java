package onmobile.atlantis.mms.hibernateModel.binary;

import java.io.Serializable;
import java.util.Date;

public class MMBinaryWarehouseDetails implements Serializable {
    private String binaryId;
    private String filePath;
    private String fileSizeInBytes;
    private String contentTypeName;
    private String contentProviderId;
    private String contentSubTypeId;
    private String contentProviderName;
    private String contentSubTypeName;
    private Date   created;
    private String createdBy;
    private Date   lastModified;
    private String lastModifiedBy;
    private Date   stateOn;
    private String stateBy;
    private String stateName;
    private String stateReason;
    private String fileExtension;
	
    public String getBinaryId() {
		return binaryId;
	}
	public void setBinaryId(String binaryId) {
		this.binaryId = binaryId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileSizeInBytes() {
		return fileSizeInBytes;
	}
	public void setFileSizeInBytes(String fileSizeInBytes) {
		this.fileSizeInBytes = fileSizeInBytes;
	}
	public String getContentTypeName() {
		return contentTypeName;
	}
	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}
	public String getContentProviderId() {
		return contentProviderId;
	}
	public void setContentProviderId(String contentProviderId) {
		this.contentProviderId = contentProviderId;
	}
	public String getContentSubTypeId() {
		return contentSubTypeId;
	}
	public void setContentSubTypeId(String contentSubTypeId) {
		this.contentSubTypeId = contentSubTypeId;
	}
	public String getContentProviderName() {
		return contentProviderName;
	}
	public void setContentProviderName(String contentProviderName) {
		this.contentProviderName = contentProviderName;
	}
	public String getContentSubTypeName() {
		return contentSubTypeName;
	}
	public void setContentSubTypeName(String contentSubTypeName) {
		this.contentSubTypeName = contentSubTypeName;
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
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}    
}
