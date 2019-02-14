package datalayer.factories;

import org.hibernate.Session;

import datalayer.dao.GenericHibernateDAO;
import datalayer.dao.ProjectDAO;
import datalayer.dao.SchaalDAO;
import datalayer.dao.TelnummerDAO;
import datalayer.dao.WerkDAO;
import datalayer.dao.WerknemerDAO;
import datalayer.interfaces.IProjectDAO;
import datalayer.interfaces.ISchaalDAO;
import datalayer.interfaces.ITelnummerDAO;
import datalayer.interfaces.IWerkDAO;
import datalayer.interfaces.IWerknemerDAO;
import datalayer.utils.HibernateSessionManager;
import domain.model.Project;
import domain.model.Schaal;
import domain.model.Telnummer;
import domain.model.Werk;
import domain.model.Werknemer;

/**
 * @author huelbr (Bram van Huele)
 * @since 12 nov. 2018
 */
public class HibernateDAOfactory extends DAOFactory {

	protected Session getCurrentSession() {
		return HibernateSessionManager.getSessionFactory().openSession();
	}

	@Override
	public IProjectDAO getProjectDAO() {
		GenericHibernateDAO<Project, Integer> dao = null;
		try {
			dao = ProjectDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (IProjectDAO) dao;
	}

	@Override
	public IWerknemerDAO getWerknemerDAO() {
		GenericHibernateDAO<Werknemer, String> dao = null;
		try {
			dao = WerknemerDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (IWerknemerDAO) dao;
	}
	

	@Override
	public ISchaalDAO getSchaalDAO() {
		GenericHibernateDAO<Schaal, Integer> dao = null;
		try {
			dao = SchaalDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (ISchaalDAO) dao;
	}
	
	@Override
	public ITelnummerDAO getTelnummerDAO() {
		GenericHibernateDAO<Telnummer, Integer> dao = null;
		try {
			dao = TelnummerDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (ITelnummerDAO) dao;
	}
	
	@Override
	public IWerkDAO getWerkDAO() {
		GenericHibernateDAO<Werk, Integer> dao = null;
		try {
			dao = WerkDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (IWerkDAO) dao;
	}
}
