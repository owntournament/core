package org.owntournament.core.interfaces.models;

public interface IBaseGameDTO extends IBaseDTO {
	IBasePouleDTO getPoule();
	void setPoule(IBasePouleDTO poule);
	int getGamenumber();
	void setGamenumber(int gamenumber);
	IBaseTeamDTO getHometeam();
	void setHometeam(IBaseTeamDTO hometeam);
	IBaseTeamDTO getAwayteam();
	void setAwayteam(IBaseTeamDTO awayteam);
	int getHomegoals();
	void setHomegoals(int homegoals);
	int getAwaygoals();
	void setAwaygoals(int awaygoals);
}
