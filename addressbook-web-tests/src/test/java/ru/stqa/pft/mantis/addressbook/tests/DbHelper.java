package ru.stqa.pft.mantis.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.mantis.addressbook.model.ContactData;
import ru.stqa.pft.mantis.addressbook.model.Contacts;
import ru.stqa.pft.mantis.addressbook.model.GroupData;
import ru.stqa.pft.mantis.addressbook.model.Groups;

import java.util.List;

/**
 * Created by anastasia.papko on 02.05.2017.
 */
public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
     sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public Groups groups() {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      List<GroupData> result = session.createQuery( "from GroupData " ).list();
      session.getTransaction().commit();
      session.close();
      return new Groups(result);
    }

  public Contacts contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery( "from ContactData where deprecated = '0000-00-00'" ).list();
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }
  public Contacts contactById(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery( "from ContactData where deprecated = '0000-00-00' and id = '" + id + "'").list();
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }
  public Contacts contactsFromGroup() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery( "from ContactData as c " +
            "left join fetch c.groups as g where g.id != null and c.deprecated = '0000-00-00'" ).list();
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }
  public Contacts contactsWithoutGroups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData as c " +
            "left join fetch c.groups as g where g.id = null and c.deprecated = '0000-00-00'").list();
    session.getTransaction().commit();
    System.out.println(result.toString());
    session.close();
    return new Contacts(result);
  }

}



