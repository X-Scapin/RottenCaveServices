package org.isep.rottencave.dao;

import java.util.List;

import org.isep.rottencave.model.PlayerResult;

public interface PlayerResultDao {
	public void persistPlayerResult(PlayerResult pr);
	public PlayerResult findPlayerResultById(int id);
	public void updatePlayerResult(PlayerResult pr);
	public void removePlayerResult(int id);
	public List<PlayerResult> listPlayerResults();
}
