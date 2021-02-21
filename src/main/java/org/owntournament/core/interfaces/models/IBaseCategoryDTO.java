package org.owntournament.core.interfaces.models;

import java.util.List;

public interface IBaseCategoryDTO extends IBaseDTO {
	String getName();
	void setName(String name);
	
	List<? extends IBasePlayingfieldDTO> getPlayingfields();
	void setPlayingfields(List<? extends IBasePlayingfieldDTO> playingfields);
}
