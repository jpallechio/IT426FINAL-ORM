package io.importing;

import model.CarPart;
import model.PartsDatabase;
import model.SessionThing;
import org.hibernate.Session;

import java.util.Collection;

public class HibernateImporter implements IImporter {

    @Override
    public boolean importParts(PartsDatabase partsDB) {
        //session manages interactions with the database
        Session session = SessionThing.getSession();
        session.beginTransaction();

        Collection<CarPart> parts = session.createQuery("from CarPart")
                .list();
        //commit changes
        session.getTransaction().commit();
        session.close();

        for(CarPart part : parts){
            partsDB.addPart(part);
        }
        return true;
    }
}
