package server.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.clases.Usuario;

//This class implements Singleton and DAO patterns
public class UsuarioDAO extends DataAccessObjectBase implements IDataAccessObject<Usuario> {

	private static UsuarioDAO instance;	
	
	private UsuarioDAO() { }
	
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}		
		
		return instance;
	}	
	
	@Override
	public void save(Usuario object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Usuario object) {
		super.deleteObject(object);
	}

	@Override
	public List<Usuario> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<Usuario> usuarios = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Usuario> usuExtent = pm.getExtent(Usuario.class, true);
			
			for (Usuario usuario : usuExtent) {
				usuarios.add(usuario);
			}
						
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all users: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuarios;
	}

	@Override
	public Usuario find(String param) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Usuario resultado = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email == '" + param + "'");
			query.setUnique(true);
			resultado = (Usuario) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a User: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return resultado;
	}
}