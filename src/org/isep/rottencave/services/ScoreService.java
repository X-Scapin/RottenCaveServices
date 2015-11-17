package org.isep.rottencave.services;

import java.util.List;

import org.isep.rottencave.dao.PlayerResultDaoImpl;
import org.isep.rottencave.model.PlayerResult;

public class ScoreService {	
	private PlayerResultDaoImpl playerResultDao;
	
	public ScoreService() {
		playerResultDao = new PlayerResultDaoImpl();
	}
	
	public void persistScore(PlayerResult pr){
		playerResultDao.createCurrentSessionWithTansaction();
		playerResultDao.persistPlayerResult(pr);
		playerResultDao.closeCurrentSessionWithTansaction();
	}
	
	public void updateScore(PlayerResult pr){
		playerResultDao.createCurrentSessionWithTansaction();
		playerResultDao.updatePlayerResult(pr);
		playerResultDao.closeCurrentSessionWithTansaction();
	}
	
	public PlayerResult findById(int id){
		playerResultDao.createCurrentSession();
		PlayerResult pr = playerResultDao.findPlayerResultById(id);
		playerResultDao.closeCurrentSession();
		return pr;
	}
	
	public void deleteScore(int id){
		playerResultDao.createCurrentSessionWithTansaction();
		playerResultDao.removePlayerResult(id);
		playerResultDao.closeCurrentSessionWithTansaction();
	}
	
	public List<PlayerResult> listScores(){
		playerResultDao.createCurrentSession();
		List<PlayerResult> prs = playerResultDao.listPlayerResults();
		playerResultDao.closeCurrentSession();
		return prs;
	}
}
