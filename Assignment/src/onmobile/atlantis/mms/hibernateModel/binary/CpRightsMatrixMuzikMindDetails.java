package onmobile.atlantis.mms.hibernateModel.binary;

import java.io.Serializable;
import java.util.Date;

public class CpRightsMatrixMuzikMindDetails implements Serializable {

	private String binaryMapId;
	private String whSongName;
	private String whMovieName;
	private String languageName;
	private String rightsBodyId;
	private String labelId;
	private String contentProviderId;
	private String rightsBodyName;
	private String labelName;
	private String contentProviderName;
	
	private Date bsnlStartDate;
	private Date bsnlEndDate;
	private String bsnlState ;
	
	private Date created;
	private String createdBy;
	private Date lastModified;
	private String lastModifiedBy;
	
	
	public String getBinaryMapId() {
		return binaryMapId;
	}
	public void setBinaryMapId(String binaryMapId) {
		this.binaryMapId = binaryMapId;
	}
	public String getWhSongName() {
		return whSongName;
	}
	public void setWhSongName(String whSongName) {
		this.whSongName = whSongName;
	}
	public String getWhMovieName() {
		return whMovieName;
	}
	public void setWhMovieName(String whMovieName) {
		this.whMovieName = whMovieName;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getRightsBodyId() {
		return rightsBodyId;
	}
	public void setRightsBodyId(String rightsBodyId) {
		this.rightsBodyId = rightsBodyId;
	}
	public String getLabelId() {
		return labelId;
	}
	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}
	public String getContentProviderId() {
		return contentProviderId;
	}
	public void setContentProviderId(String contentProviderId) {
		this.contentProviderId = contentProviderId;
	}
	public String getRightsBodyName() {
		return rightsBodyName;
	}
	public void setRightsBodyName(String rightsBodyName) {
		this.rightsBodyName = rightsBodyName;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getContentProviderName() {
		return contentProviderName;
	}
	public void setContentProviderName(String contentProviderName) {
		this.contentProviderName = contentProviderName;
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
	
	
}
