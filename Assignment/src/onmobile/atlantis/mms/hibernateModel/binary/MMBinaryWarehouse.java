package onmobile.atlantis.mms.hibernateModel.binary;

import java.io.Serializable;
import java.util.Date;

public class MMBinaryWarehouse implements Serializable {
    private String binaryId;
    private String contentProviderId;
    private String filePath;
    private String fileSizeInBytes;
    private Date   startDate;
    private Date   endDate;
    private String contentTypeName;
    private String contentSubTypeId;
    private String fileExtension;
    private Date   created;
    private String createdBy;
    private Date   lastModified;
    private String lastModifiedBy;
    private Date   stateOn;
    private String stateBy;
    private String stateName;
    private String stateReason;
    private String callFromTrigger;
        
    public String getBinaryId() {
        return binaryId;
    }
    public void setBinaryId(String binaryId) {
        this.binaryId = binaryId;
    }
    public String getContentProviderId() {
        return contentProviderId;
    }
    public void setContentProviderId(String contentProviderId) {
        this.contentProviderId = contentProviderId;
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
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getContentTypeName() {
        return contentTypeName;
    }
    public void setContentTypeName(String contentTypeName) {
        this.contentTypeName = contentTypeName;
    }
    public String getContentSubTypeId() {
        return contentSubTypeId;
    }
    public void setContentSubTypeId(String contentSubTypeId) {
        this.contentSubTypeId = contentSubTypeId;
    }
    public String getFileExtension() {
        return fileExtension;
    }
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
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
   
    
   
}
