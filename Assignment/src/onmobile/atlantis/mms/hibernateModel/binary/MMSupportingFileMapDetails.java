package onmobile.atlantis.mms.hibernateModel.binary;

import java.io.Serializable;
import java.util.Date;

public class MMSupportingFileMapDetails implements Serializable {
	
	private String binaryMapId;
	private String whSongName;
	private String whSongNameRx;
	private String whMovieName;
	private String whMovieNameRx;
	private String languageName;
	private String rightsBodyId;
	private String labelId;
	private String cpContentId;
	private String songReleaseDate;
	private String movieReleaseDate;
	private String songReleaseYear;
	private String movieReleaseYear;
	private String actor;
	private String singer;
	private String musicDirector;
	private String movieDirector;
	private String rightsBodyName;
	private String labelName;
	private String movieProducer;
	private String contentProviderName;
	private String contentProviderId;
	private String editedBinaryId;
	private String editedFilePath;
	private String editedContentTypeName;
	private String shortPromptBinaryId;
	private String shortPromptFilePath;
	private String shortPromptContentTypeName;
	private String longPromptBinaryId;
	private String longPromptFilePath;
	private String longPromptContentTypeName;
	private String option1PromptBinaryId;
	private String option1PromptFilePath;
	private String option1ContentTypeName;
	private String option2PromptBinaryId;
	private String option2PromptFilePath;
	private String option2ContentTypeName;
	private String option3PromptBinaryId;
	private String option3PromptFilePath;
	private String option3ContentTypeName;
	private String option4PromptBinaryId;
	private String option4PromptFilePath;
	private String option4ContentTypeName;
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
	
	public String getSongReleaseYear() {
		return songReleaseYear;
	}
	public void setSongReleaseYear(String songReleaseYear) {
		this.songReleaseYear = songReleaseYear;
	}
	public String getMovieReleaseYear() {
		return movieReleaseYear;
	}
	public void setMovieReleaseYear(String movieReleaseYear) {
		this.movieReleaseYear = movieReleaseYear;
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
	public String getWhSongName() {
		return whSongName;
	}
	public void setWhSongName(String whSongName) {
		this.whSongName = whSongName;
	}
	public String getWhSongNameRx() {
		return whSongNameRx;
	}
	public void setWhSongNameRx(String whSongNameRx) {
		this.whSongNameRx = whSongNameRx;
	}
	public String getWhMovieName() {
		return whMovieName;
	}
	public void setWhMovieName(String whMovieName) {
		this.whMovieName = whMovieName;
	}
	public String getWhMovieNameRx() {
		return whMovieNameRx;
	}
	
	public String getContentProviderId() {
		return contentProviderId;
	}
	public void setContentProviderId(String contentProviderId) {
		this.contentProviderId = contentProviderId;
	}
	public void setWhMovieNameRx(String whMovieNameRx) {
		this.whMovieNameRx = whMovieNameRx;
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
	public String getCpContentId() {
		return cpContentId;
	}
	public void setCpContentId(String cpContentId) {
		this.cpContentId = cpContentId;
	}
	public String getSongReleaseDate() {
		return songReleaseDate;
	}
	public void setSongReleaseDate(String songReleaseDate) {
		this.songReleaseDate = songReleaseDate;
	}
	public String getMovieReleaseDate() {
		return movieReleaseDate;
	}
	public void setMovieReleaseDate(String movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getMusicDirector() {
		return musicDirector;
	}
	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
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
	public String getMovieProducer() {
		return movieProducer;
	}
	public void setMovieProducer(String movieProducer) {
		this.movieProducer = movieProducer;
	}
	public String getContentProviderName() {
		return contentProviderName;
	}
	public void setContentProviderName(String contentProviderName) {
		this.contentProviderName = contentProviderName;
	}
	public String getEditedBinaryId() {
		return editedBinaryId;
	}
	public void setEditedBinaryId(String editedBinaryId) {
		this.editedBinaryId = editedBinaryId;
	}
	public String getEditedFilePath() {
		return editedFilePath;
	}
	public void setEditedFilePath(String editedFilePath) {
		this.editedFilePath = editedFilePath;
	}
	public String getEditedContentTypeName() {
		return editedContentTypeName;
	}
	public void setEditedContentTypeName(String editedContentTypeName) {
		this.editedContentTypeName = editedContentTypeName;
	}
	public String getShortPromptBinaryId() {
		return shortPromptBinaryId;
	}
	public void setShortPromptBinaryId(String shortPromptBinaryId) {
		this.shortPromptBinaryId = shortPromptBinaryId;
	}
	public String getShortPromptFilePath() {
		return shortPromptFilePath;
	}
	public void setShortPromptFilePath(String shortPromptFilePath) {
		this.shortPromptFilePath = shortPromptFilePath;
	}
	public String getShortPromptContentTypeName() {
		return shortPromptContentTypeName;
	}
	public void setShortPromptContentTypeName(String shortPromptContentTypeName) {
		this.shortPromptContentTypeName = shortPromptContentTypeName;
	}
	public String getLongPromptBinaryId() {
		return longPromptBinaryId;
	}
	public void setLongPromptBinaryId(String longPromptBinaryId) {
		this.longPromptBinaryId = longPromptBinaryId;
	}
	public String getLongPromptFilePath() {
		return longPromptFilePath;
	}
	public void setLongPromptFilePath(String longPromptFilePath) {
		this.longPromptFilePath = longPromptFilePath;
	}
	public String getLongPromptContentTypeName() {
		return longPromptContentTypeName;
	}
	public void setLongPromptContentTypeName(String longPromptContentTypeName) {
		this.longPromptContentTypeName = longPromptContentTypeName;
	}
	public String getOption1PromptBinaryId() {
		return option1PromptBinaryId;
	}
	public void setOption1PromptBinaryId(String option1PromptBinaryId) {
		this.option1PromptBinaryId = option1PromptBinaryId;
	}
	public String getOption1PromptFilePath() {
		return option1PromptFilePath;
	}
	public void setOption1PromptFilePath(String option1PromptFilePath) {
		this.option1PromptFilePath = option1PromptFilePath;
	}
	public String getOption1ContentTypeName() {
		return option1ContentTypeName;
	}
	public void setOption1ContentTypeName(String option1ContentTypeName) {
		this.option1ContentTypeName = option1ContentTypeName;
	}
	public String getOption2PromptBinaryId() {
		return option2PromptBinaryId;
	}
	public void setOption2PromptBinaryId(String option2PromptBinaryId) {
		this.option2PromptBinaryId = option2PromptBinaryId;
	}
	public String getOption2PromptFilePath() {
		return option2PromptFilePath;
	}
	public void setOption2PromptFilePath(String option2PromptFilePath) {
		this.option2PromptFilePath = option2PromptFilePath;
	}
	public String getOption2ContentTypeName() {
		return option2ContentTypeName;
	}
	public void setOption2ContentTypeName(String option2ContentTypeName) {
		this.option2ContentTypeName = option2ContentTypeName;
	}
	public String getOption3PromptBinaryId() {
		return option3PromptBinaryId;
	}
	public void setOption3PromptBinaryId(String option3PromptBinaryId) {
		this.option3PromptBinaryId = option3PromptBinaryId;
	}
	public String getOption3PromptFilePath() {
		return option3PromptFilePath;
	}
	public void setOption3PromptFilePath(String option3PromptFilePath) {
		this.option3PromptFilePath = option3PromptFilePath;
	}
	public String getOption3ContentTypeName() {
		return option3ContentTypeName;
	}
	public void setOption3ContentTypeName(String option3ContentTypeName) {
		this.option3ContentTypeName = option3ContentTypeName;
	}
	public String getOption4PromptBinaryId() {
		return option4PromptBinaryId;
	}
	public void setOption4PromptBinaryId(String option4PromptBinaryId) {
		this.option4PromptBinaryId = option4PromptBinaryId;
	}
	public String getOption4PromptFilePath() {
		return option4PromptFilePath;
	}
	public void setOption4PromptFilePath(String option4PromptFilePath) {
		this.option4PromptFilePath = option4PromptFilePath;
	}
	public String getOption4ContentTypeName() {
		return option4ContentTypeName;
	}
	public void setOption4ContentTypeName(String option4ContentTypeName) {
		this.option4ContentTypeName = option4ContentTypeName;
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
