/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.kinoService.SeatRow;
import generated.kinoService.Categorie;
import generated.kinoService.Seat;
import java.util.Set;
public interface ISeatRow extends Identifiable{
   public SeatRow getTheObject();
   public Integer getId();
   public Categorie getCategorie() throws PersistenceException;
   public void setCategorie(Categorie newCategorie)throws PersistenceException;
   public Integer getNumberOfSeats() ;
   public void setNumberOfSeats(Integer newNumberOfSeats) throws PersistenceException;
   public Set<Seat> getSeat() throws PersistenceException;
}
