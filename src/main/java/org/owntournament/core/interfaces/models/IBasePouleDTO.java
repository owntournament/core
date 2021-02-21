package org.owntournament.core.interfaces.models;

import java.util.List;

public interface IBasePouleDTO extends IBaseDTO{
	String getPoulename();
	void setPoulename(String poulename);
	IBaseCategoryDTO getCategory();
	void setCategory(IBaseCategoryDTO category);
	List<? extends IBasePoulestandingDTO> getPoulestanding();
	void setPoulestanding(List<? extends IBasePoulestandingDTO> teams);
}
