package gestionpersistencia;

import clasesPersistencia.Client;
import clasesPersistencia.Sector;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

public class GestorClient implements Serializable {

    private EntityManager manager = null;

    public GestorClient(EntityManager manager) {
        this.manager = manager;
    }

    public void insert(Client cliente) {
        try {
            this.manager.getTransaction().begin();
            this.manager.persist(cliente);
            this.manager.getTransaction().commit();
            System.out.println("Cliente añadido con éxito");
        } catch (Exception e) {
            System.out.println("No ha sido posible insertar el nuevo cliente");
        }
    }

    public void update(Client cliente) {
        try {
            this.manager.getTransaction().begin();
            this.manager.merge(cliente);
            this.manager.getTransaction().commit();
            System.out.println("Cliente modificado con éxito");
        } catch (EntityNotFoundException e) {
            System.out.println("No ha sido posible encontrar el cliente");
        }
    }

    public void delete(int id) {
        try {
            Client cliente;
            this.manager.getTransaction().begin();
            cliente = this.manager.getReference(Client.class, id);
            this.manager.remove(cliente);
            this.manager.getTransaction().commit();
            System.out.println("Cliente eliminado con éxito");
        } catch (EntityNotFoundException e) {
            System.out.println("No ha sido posible eliminar el cliente");
        }
    }

    public Client getClientById(int id) {
        return this.manager.getReference(Client.class, id);
    }

    public Client getClientByNif(String nif) {
        Query query = this.manager.createNamedQuery("Client.clientByNif", Client.class);
        query.setParameter("nif", nif);
        return (Client) query.getSingleResult();
    }

    public List<Client> getClientsByName(String nombre) {
        Query query = this.manager.createNamedQuery("Client.clientsByNom", Client.class);
        String nombreBuscado = "%" + nombre + "%";
        query.setParameter("nom", nombreBuscado);
        return query.getResultList();
    }

    public List<Client> getClientsBySector(Sector sector) {
        Query query = this.manager.createNamedQuery("Client.clientsBySector", Client.class);
        query.setParameter("sector", sector);
        return query.getResultList();
    }
}
