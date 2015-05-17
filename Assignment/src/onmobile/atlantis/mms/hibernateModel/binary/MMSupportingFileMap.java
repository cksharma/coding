package onmobile.atlantis.mms.hibernateModel.binary;

import java.io.Serializable;
import java.util.Date;

public class MMSupportingFileMap implements Serializable {
	
	private String binaryMapId;
	private String editedBinaryId;
	private String shortPromptBinaryId;
	private String longPromptBinaryId;
	private String option1PromptBinaryId;
	private String option2PromptBinaryId;
	private String option3PromptBinaryId;
	private String option4PromptBinaryId;
	private String songNameGrammar;
	private String artistGrammar;
	private String albumGrammar;
	private String option1Script;
	private String option2Script;
	private String option3Script;
	private String option4Script;
	private String answer;
	private String confidence;
	private String grammarLanguageModel;
	private Date created;
	private String createdBy;
	private Date lastModified;
	private String lastModifiedBy;
	private Date stateOn;
	private String stateBy;
	private String stateName;
	private String stateReason;
	private String callFromTrigger;
	private String holderContentSubTypeId;
	private String holderContentSubTypeName;
	
	public String getStateBy() {
		return stateBy;
	}
	public void setStateBy(String stateBy) {
		this.stateBy = stateBy;
	}
	public Date getStateOn() {
		return stateOn;
	}
	public void setStateOn(Date stateOn) {
		this.stateOn = stateOn;
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
	public String getHolderContentSubTypeId() {
		return holderContentSubTypeId;
	}
	public void setHolderContentSubTypeId(String holderContentSubTypeId) {
		this.holderContentSubTypeId = holderContentSubTypeId;
	}
	public String getHolderContentSubTypeName() {
		return holderContentSubTypeName;
	}
	public void setHolderContentSubTypeName(String holderContentSubTypeName) {
		this.holderContentSubTypeName = holderContentSubTypeName;
	}
	public String getBinaryMapId() {
		return binaryMapId;
	}
	public void setBinaryMapId(String binaryMapId) {
		this.binaryMapId = binaryMapId;
	}
	public String getEditedBinaryId() {
		return editedBinaryId;
	}
	public void setEditedBinaryId(String editedBinaryId) {
		this.editedBinaryId = editedBinaryId;
	}
	public String getShortPromptBinaryId() {
		return shortPromptBinaryId;
	}
	public void setShortPromptBinaryId(String shortPromptBinaryId) {
		this.shortPromptBinaryId = shortPromptBinaryId;
	}
	public String getLongPromptBinaryId() {
		return longPromptBinaryId;
	}
	public void setLongPromptBinaryId(String longPromptBinaryId) {
		this.longPromptBinaryId = longPromptBinaryId;
	}
	public String getOption1PromptBinaryId() {
		return option1PromptBinaryId;
	}
	public void setOption1PromptBinaryId(String option1PromptBinaryId) {
		this.option1PromptBinaryId = option1PromptBinaryId;
	}
	public String getOption2PromptBinaryId() {
		return option2PromptBinaryId;
	}
	public void setOption2PromptBinaryId(String option2PromptBinaryId) {
		this.option2PromptBinaryId = option2PromptBinaryId;
	}
	public String getOption3PromptBinaryId() {
		return option3PromptBinaryId;
	}
	public void setOption3PromptBinaryId(String option3PromptBinaryId) {
		this.option3PromptBinaryId = option3PromptBinaryId;
	}
	public String getOption4PromptBinaryId() {
		return option4PromptBinaryId;
	}
	public void setOption4PromptBinaryId(String option4PromptBinaryId) {
		this.option4PromptBinaryId = option4PromptBinaryId;
	}
	public String getSongNameGrammar() {
		return songNameGrammar;
	}
	public void setSongNameGrammar(String songNameGrammar) {
		this.songNameGrammar = songNameGrammar;
	}
	public String getArtistGrammar() {
		return artistGrammar;
	}
	public void setArtistGrammar(String artistGrammar) {
		this.artistGrammar = artistGrammar;
	}
	public String getAlbumGrammar() {
		return albumGrammar;
	}
	public void setAlbumGrammar(String albumGrammar) {
		this.albumGrammar = albumGrammar;
	}
	public String getOption1Script() {
		return option1Script;
	}
	public void setOption1Script(String option1Script) {
		this.option1Script = option1Script;
	}
	public String getOption2Script() {
		return option2Script;
	}
	public void setOption2Script(String option2Script) {
		this.option2Script = option2Script;
	}
	public String getOption3Script() {
		return option3Script;
	}
	public void setOption3Script(String option3Script) {
		this.option3Script = option3Script;
	}
	public String getOption4Script() {
		return option4Script;
	}
	public void setOption4Script(String option4Script) {
		this.option4Script = option4Script;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getConfidence() {
		return confidence;
	}
	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}
	public String getGrammarLanguageModel() {
		return grammarLanguageModel;
	}
	public void setGrammarLanguageModel(String grammarLanguageModel) {
		this.grammarLanguageModel = grammarLanguageModel;
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
