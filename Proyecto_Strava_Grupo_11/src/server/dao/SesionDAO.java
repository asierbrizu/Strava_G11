package server.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.clases.SesionEntrenamiento;

//This class implements Singleton and DAO patterns
public class SesionDAO extends DataAccessObjectBase implements IDataAccessObject<SesionEntrenamiento> {

	private static SesionDAO instance;	
	
	private SesionDAO() { }
	
	public static SesionDAO getInstance() {
		if (instance == null) {
			instance = new SesionDAO();
		}		
		
		return instance;
	}	
	
	@Override
	public void save(SesionEntrenamiento object) {
		super.saveObject(object);
	}

	@Override
	public void delete(SesionEntrenamiento object) {
		super.deleteObject(object);
	}

	@Override
	public List<SesionEntrenamiento> getAll() {
		
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<SesionEntrenamiento> sesiones = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<SesionEntrenamiento> sesionExtent = pm.getExtent(SesionEntrenamiento.class, true);
			
			for (SesionEntrenamiento sesion : sesionExtent) {
				sesiones.add(sesion);
			}
						
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all Sesions: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return sesiones;
	}

	@Override
	public SesionEntrenamiento find(String param) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		SesionEntrenamiento resultado = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + SesionEntrenamiento.class.getName() + " WHERE titulo == '" + param + "'");
			query.setUnique(true);
			resultado = (SesionEntrenamiento) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Sesion: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return resultado;
	}
}