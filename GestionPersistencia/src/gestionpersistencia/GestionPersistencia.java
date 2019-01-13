package gestionpersistencia;

import clasesPersistencia.Client;
import clasesPersistencia.Sector;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestionPersistencia {

    public static void main(String[] args) {

        /* ------------ Creamos gestor de Clientes ------------ */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersistencia");
        EntityManager manager = emf.createEntityManager();
        GestorClient gestor = new GestorClient(manager);

        /* ------------ Pruebas Gestor ------------ */
        
//        /* Prueba Inserción */
//        Client c1 = new Client("11111", "Javi");
//        Client c2 = new Client("22222", "Silvia");
//        gestor.insert(c1);
//        gestor.insert(c2);
        
//        /* Prueba Modificación */
//        Client c = gestor.getClientByNif("22222");
//        c.setNom("Marta");
//        gestor.update(c);
        
//        /* Prueba Eliminación */
//        Client c = gestor.getClientByNif("11111");
//        gestor.delete(c.getId());
        
//        /* Prueba Filtro ID */
//        Client c1 = new Client("33333", "Bernat");
//        Client c2 = new Client("44444", "Alejandra");
//        Client c3 = new Client("55555", "María");
//        Client c4 = new Client("66666", "Pau");
//        gestor.insert(c1);
//        gestor.insert(c2);
//        gestor.insert(c3);
//        gestor.insert(c4);
//        Client cliente = gestor.getClientById(4);
//        imprimirCliente(cliente);
        
//        /* Prueba Filtro Nif */
//        Client cliente = gestor.getClientByNif("66666");
//        imprimirCliente(cliente);
        
//        /* Prueba Filtro Nom */
//        List<Client> listaPorNombre = gestor.getClientsByName("Mar");
//        imprimirLista(listaPorNombre);
        
//        /* Prueba Filtro Sector */
//        Client c1 = new Client("12345", "Laura");
//        Client c2 = new Client("54321", "Oscar");
//        Client c3 = new Client("90478", "Jose");
//        
//        Sector s = new Sector("3333", "Sector bla bla");
//        c1.setSector(s);
//        c3.setSector(s);
//        
//        insertarSector(manager, s);
//        gestor.insert(c1);
//        gestor.insert(c2);
//        gestor.insert(c3);
//
//        List<Client> listaPorSector = gestor.getClientsBySector(s);
//        imprimirLista(listaPorSector);
    }

    public static void insertarSector(EntityManager m, Sector s) {
        m.getTransaction().begin();
        m.persist(s);
        m.getTransaction().commit();
    }

    public static void imprimirCliente(Client c) {
        System.out.println("Cliente Individual");
        System.out.println("Id del cliente: " + c.getId());
        System.out.println("Nif del cliente: " + c.getNif());
        System.out.println("Nombre del cliente: " + c.getNom());
        System.out.println();
    }

    public static void imprimirLista(List<Client> lista) {
        System.out.println("Lista de Clientes");
        for (Client c : lista) {
            System.out.println(c.getId() + " " + c.getNif() + " " + c.getNom());
        }
        System.out.println();
    }
}
