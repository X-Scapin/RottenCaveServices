package org.isep.rottencave.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.isep.rottencave.model.PlayerResult;
import org.rottencave.util.HibernateSessions;

public class PlayerResultDaoImpl implements PlayerResultDao {
	private Session currentSession;
	private Transaction currentTransaction;

	@Override
	public void persistPlayerResult(PlayerResult pr) {
		currentSession.persist(pr);
	}

	@Override
	public PlayerResult findPlayerResultById(int id) {
		PlayerResult pr = (PlayerResult) currentSession.get(PlayerResult.class, id);
		return pr;
	}

	@Override
	public void updatePlayerResult(PlayerResult pr) {
		currentSession.update(pr);
	}

	@Override
	public void removePlayerResult(int id) {
		currentSession.delete(id);
	}

	@Override
	public List<PlayerResult> listPlayerResults() {
		@SuppressWarnings("unchecked")
		List<PlayerResult> scores = (List<PlayerResult>) currentSession.createQuery("from PlayerResult").list();
		return scores;
	}
	
	/*
	 * Methods to manage session
	 */
	
	public Session createCurrentSession(){
		currentSession = HibernateSessions.getSessionFactory().openSession();
		return currentSession;
	}
	
	public void closeCurrentSession(){
		currentSession.close();
	}
	
	public Session createCurrentSessionWithTansaction(){
		currentSession = HibernateSessions.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSessionWithTansaction(){
		currentTransaction.commit();
		currentSession.close();
	}
}
