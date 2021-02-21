package org.owntournament.core.interfaces.models;

public interface IBaseTeamDTO extends IBaseDTO {
	String getName();
	void setName(String name);
	IBaseCategoryDTO getCategory();
	void setCategory(IBaseCategoryDTO category);
}
