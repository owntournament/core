package org.owntournament.core.interfaces.models;

public interface IBasePoulestandingDTO extends IBaseDTO {
	int getPosition();
	void setPosition(int positie);
	IBaseTeamDTO getTeam();
	void setTeam(IBaseTeamDTO team);
	int getGamesPlayed();
	void setGamesPlayed(int gespeeld);
	int getGamesWon();
	void setGamesWon(int gewonnen);
	int getGamesDrawn();
	void setGamesDrawn(int gelijk);
	int getGamesLost();
	void setGamesLost(int verloren);
	int getPoints();
	void setPoints(int punten);
}
