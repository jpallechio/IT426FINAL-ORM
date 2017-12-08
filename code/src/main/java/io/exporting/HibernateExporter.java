package io.exporting;

import model.CarPart;
import model.PartsDatabase;
import model.SessionThing;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collection;


public class HibernateExporter implements IExporter {
    Session session = SessionThing.getSession();

    @Override
    public boolean exportParts(PartsDatabase partsDB) {
        if (partsDB.isEmpty()) {
            return false;
        }
        session.beginTransaction();
        //clear table
        clearTable("CarPart");

        Collection<CarPart> parts = partsDB.getParts();

        for (CarPart part : parts) {
            //save a new record
            session.save(part);
            session.flush();
            session.clear();
        }
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public int clearTable(String myTable) {
        String hql = String.format("delete from %s", myTable);
        Query query = session.createQuery(hql);
        return query.executeUpdate();
    }
}
