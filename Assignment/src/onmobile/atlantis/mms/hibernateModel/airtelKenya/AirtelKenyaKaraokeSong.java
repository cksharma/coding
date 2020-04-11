package onmobile.atlantis.mms.hibernateModel.airtelKenya;

import java.io.Serializable;
import java.util.Date;

public class AirtelKenyaKaraokeSong implements Serializable {

	private String binaryMapId;
	private String airtelKenyaKaraokeClipId;
	private String mapChangeFlag;
	private Date created;
	private String createdBy;
	private Date lastModified;
	private String lastModifiedBy;
	private Date stateOn;
	private String stateBy;
	private String stateName;
	private String stateReason;
	private Date holderStartDate;
	private Date holderEndDate;
	
	public String getBinaryMapId() {
		return binaryMapId;
	}
	public void setBinaryMapId(String binaryMapId) {
		this.binaryMapId = binaryMapId;
	}
	public String getAirtelKenyaKaraokeClipId() {
		return airtelKenyaKaraokeClipId;
	}
	public void setAirtelKenyaKaraokeClipId(String airtelKenyaKaraokeClipId) {
		this.airtelKenyaKaraokeClipId = airtelKenyaKaraokeClipId;
	}
	public String getMapChangeFlag() {
		return mapChangeFlag;
	}
	public void setMapChangeFlag(String mapChangeFlag) {
		this.mapChangeFlag = mapChangeFlag;
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
	public Date getHolderStartDate() {
		return holderStartDate;
	}
	public void setHolderStartDate(Date holderStartDate) {
		this.holderStartDate = holderStartDate;
	}
	public Date getHolderEndDate() {
		return holderEndDate;
	}
	public void setHolderEndDate(Date holderEndDate) {
		this.holderEndDate = holderEndDate;
	}	
}
