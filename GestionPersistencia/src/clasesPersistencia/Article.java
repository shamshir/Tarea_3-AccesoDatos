package clasesPersistencia;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TARTICLES")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 150)
    private String descripcio;

    /**
     * Constructor per defecte
     */
    public Article() {
    }

    /**
     * Constructor que inicializa la descripció de l'article
     *
     * @param descripcio inicalitza la descripció de l'article.
     */
    public Article(String descripcio) {
        this.descripcio = descripcio;
    }

    /**
     * Constructor que inicializa el codi numèric i la descripció de l'article.
     * El codi numèric, cal que sigui menor de 100, doncs els valors superiors
     * es reserven per a fer assignacions automètiques a partir d'una sequencia
     * del SGBD.
     *
     * @param id Codi numeric de l'article.
     * @param descripcio És la descripció que caldrà assignar a l'article
     */
    public Article(Integer id, String descripcio) {
        this.id = id;
        this.descripcio = descripcio;
    }

    /**
     * Obté el codi numèroic de l'article
     *
     * @return codi numèric.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Assigna el codi numèric de l'article
     *
     * @param id Valor que s'assignarà al codi numèric de l'article
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Indica si l'objecte on es fa la crida i el que es passa per paràmetre són
     * iguals.
     *
     * @param object a comparar
     * @return cert si són iguals. Fals en cas contrari.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null)
                || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Obté una cadena representativa de l'objecte on es fa la crida
     *
     * @return cadena representativa de l'objecte
     */
    @Override
    public String toString() {
        return descripcio + " (id=" + id + ")";
    }

    /**
     * Obté la descripció de l'article
     *
     * @return la descripcio
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Assigna un valor a la descripció de l'article
     *
     * @param descripcio És el valor a assignar.
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

}
