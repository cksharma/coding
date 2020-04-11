package onmobile.atlantis.mms.hibernateModel.airtelKenya;

import java.io.Serializable;
import java.util.Date;

public class AirtelKenyaKaraokeCategory implements Serializable {
	
	private String catalogId;
	private String artworkBinaryID_1;
	private String artworkBinaryID_2;
	private String catalogName;
	private String catalogOrder;
	private String startPromptId;
	private String catalogGrammar;
	private String confirmPromptId;
	private String catalogLanguageModel;
	private Date startDate;
	private Date endDate;
	private String parentCatalogId;
	private Date created;
	private String createdBy;
	private Date lastModified;
	private String lastModifiedBy;
	private String catalogDesc;	
	
	public String getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public String getCatalogOrder() {
		return catalogOrder;
	}
	public void setCatalogOrder(String catalogOrder) {
		this.catalogOrder = catalogOrder;
	}
	public String getStartPromptId() {
		return startPromptId;
	}
	public void setStartPromptId(String startPromptId) {
		this.startPromptId = startPromptId;
	}
	public String getCatalogGrammar() {
		return catalogGrammar;
	}
	public void setCatalogGrammar(String catalogGrammar) {
		this.catalogGrammar = catalogGrammar;
	}
	public String getConfirmPromptId() {
		return confirmPromptId;
	}
	public void setConfirmPromptId(String confirmPromptId) {
		this.confirmPromptId = confirmPromptId;
	}
	public String getCatalogLanguageModel() {
		return catalogLanguageModel;
	}
	public void setCatalogLanguageModel(String catalogLanguageModel) {
		this.catalogLanguageModel = catalogLanguageModel;
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
	public String getParentCatalogId() {
		return parentCatalogId;
	}
	public void setParentCatalogId(String parentCatalogId) {
		this.parentCatalogId = parentCatalogId;
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
	public String getCatalogDesc() {
		return catalogDesc;
	}
	public void setCatalogDesc(String catalogDesc) {
		this.catalogDesc = catalogDesc;
	}
	public String getArtworkBinaryID_1() {
		return artworkBinaryID_1;
	}
	public void setArtworkBinaryID_1(String artworkBinaryID_1) {
		this.artworkBinaryID_1 = artworkBinaryID_1;
	}
	public String getArtworkBinaryID_2() {
		return artworkBinaryID_2;
	}
	public void setArtworkBinaryID_2(String artworkBinaryID_2) {
		this.artworkBinaryID_2 = artworkBinaryID_2;
	}	
	
}
