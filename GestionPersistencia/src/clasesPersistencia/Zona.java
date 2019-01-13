package clasesPersistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

@Entity
public class Zona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(length = 30)
    private String id;
    @Column(name = "descripcio", length = 100)
    private String descripcio;
    @OneToOne (mappedBy = "zona")
    private Comercial comercial;
    @OneToMany(mappedBy = "zona", fetch = FetchType.LAZY)
    @OrderBy(value = "nom")
    private List<Client> clients=new ArrayList<Client>();
    
    /**
     * Contructor per defecte
     */
    protected Zona() {
        
    }

    /**
     * Constructor que inicialitza l'identificador 
     * @param id
     */
    public Zona(String id) {
        this.id = id;
    }
    
    /**
     * Constructor que inicialitza l'identificador i la descripció
     * @param id
     * @param descripcio
     */
    public Zona(String id, String descripcio) {
        this.id = id;
        this.descripcio = descripcio;
    }
    
    /**
     * Obté el valor identificador de la zona
     * @return valor identificador
     */
    public String getId() {
        return id;
    }

    /**
     * Assigna una cadena identificativa a la zona
     * @param id valor a assignar
     */
    protected void setId(String id) {
        this.id = id;
    }

    /**
     * Obté la descripció de la zona
     * @return the descripcio
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Assigna una descripció a la zona
     * @param descripcio la descripció a assignar
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    /**
     * Obté el comercial assignat a la zona
     * @return el comercial
     */
    public Comercial getComercial() {
        return comercial;
    }

    /**
     * Assigna qui serà el comercial de la zona. 
     * @param comercial el comercial a assignar
     */
    public void setComercial(Comercial comercial) {
        if(this.comercial!=null){
            this.comercial.setZona(null);
        }
        this.comercial = comercial;
        if(comercial.getZona().equals(this)){
            this.comercial.setZona(this);    
        }
    }

    /**
     * Obté la llista de clients assignats a la zona
     * @return els clients assignats
     */
    public List<Client> getClients() {
        return clients;
    }
    
     /**
     * Indica si l'objecte on es fa la crida i el que es passa per paràmetre 
     * són iguals
     * @param object a comparar
     * @return cert si són iguals. Fals en cas contrari.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Zona)) {
            return false;
        }
        Zona other = (Zona) object;
        if ((this.id == null && other.id != null) 
                || (this.id != null 
                && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Cadena de caràcters representativa de l'objecte on es fa la crida.
     * @return Cadena de caràcters representativa de l'objecte 
     */
    @Override
    public String toString() {
        return "[zona=" + id + "]";
    }
}
