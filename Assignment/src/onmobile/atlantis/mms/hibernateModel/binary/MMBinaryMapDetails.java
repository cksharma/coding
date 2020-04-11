package onmobile.atlantis.mms.hibernateModel.binary;

import java.io.Serializable;
import java.util.Date;

public class MMBinaryMapDetails implements Serializable {
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
    private String filePath;
    private String fileSizeInBytes;
    private String contentTypeName;
    private String fileExtension;
    private String whSongName;
    private String whSongNameRx;
    private String whMovieName;
    private String whMovieNameRx;
    private String languageName;
    private String contentProviderId;
    private String rightsBodyId;
    private String labelId;
    private String cpContentId;
    private Date songReleaseDate;
    private Date movieReleaseDate;
    private String actor;
    private String singer;
    private String musicDirector;
    private String movieDirector;
    private String movieProducer;
    private String rightsBodyName;
    private String labelName;
    private String contentProviderName;
    private String songReleaseYear;
    private String movieReleaseYear;
	private String metadataStateName;
	private String metadataStateReason;
	private String binaryStateName;
	private String binaryStateReason;	
	
    public String getMetadataStateName() {
		return metadataStateName;
	}
	public void setMetadataStateName(String metadataStateName) {
		this.metadataStateName = metadataStateName;
	}
	public String getMetadataStateReason() {
		return metadataStateReason;
	}
	public void setMetadataStateReason(String metadataStateReason) {
		this.metadataStateReason = metadataStateReason;
	}
	public String getBinaryStateName() {
		return binaryStateName;
	}
	public void setBinaryStateName(String binaryStateName) {
		this.binaryStateName = binaryStateName;
	}
	public String getBinaryStateReason() {
		return binaryStateReason;
	}
	public void setBinaryStateReason(String binaryStateReason) {
		this.binaryStateReason = binaryStateReason;
	}
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
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
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
	public void setWhMovieNameRx(String whMovieNameRx) {
		this.whMovieNameRx = whMovieNameRx;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getContentProviderId() {
		return contentProviderId;
	}
	public void setContentProviderId(String contentProviderId) {
		this.contentProviderId = contentProviderId;
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
	public Date getSongReleaseDate() {
		return songReleaseDate;
	}
	public void setSongReleaseDate(Date songReleaseDate) {
		this.songReleaseDate = songReleaseDate;
	}
	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}
	public void setMovieReleaseDate(Date movieReleaseDate) {
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
	public String getMovieProducer() {
		return movieProducer;
	}
	public void setMovieProducer(String movieProducer) {
		this.movieProducer = movieProducer;
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
}
