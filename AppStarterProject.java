package domain.softwareproject.AppStarter;

import datalayer.factories.DAOFactories;
import datalayer.factories.DAOFactory;
import datalayer.utils.HibernateSessionManager;
import domain.model.Project;
import domain.model.Schaal;
import domain.model.Telnummer;
import domain.model.Werk;
import domain.model.Werknemer;


public class AppStarterProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
		
		Werknemer w = new Werknemer();
		w.setNaam("Peter");
		

		Project p = new Project("test", "Vlissingen");
		
		Schaal s = new Schaal(123, 0.00, 1.00);
		
		Telnummer t = new Telnummer(123456789, w);
		
		Werk we = new Werk(w, p, 7);
		
		
		DAOFactory.getTheFactory().getWerknemerDAO().saveOrUpdate(w);
		DAOFactory.getTheFactory().getProjectDAO().saveOrUpdate(p);
		DAOFactory.getTheFactory().getSchaalDAO().saveOrUpdate(s);
		DAOFactory.getTheFactory().getTelnummerDAO().saveOrUpdate(t);
		DAOFactory.getTheFactory().getWerkDAO().saveOrUpdate(we);
		
		HibernateSessionManager.shutdown();

	}

}
