/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.kinoService.Reservation;
import generated.kinoService.Seat;
import java.util.Set;
import generated.kinoService.Performance;
import generated.kinoService.Client;
public interface IReservation extends Identifiable{
   public Reservation getTheObject();
   public Integer getId();
   public Set<Seat> getSeat() throws PersistenceException;
   public void addToSeat(Seat arg) throws PersistenceException;
   public boolean removeFromSeat(Seat arg) throws PersistenceException;
   public Performance getPerformance() throws PersistenceException;
   public void setPerformance(Performance newPerformance)throws PersistenceException;
   public Client getClient() throws PersistenceException;
   public void setClient(Client newClient)throws PersistenceException;
   public String getValid() ;
   public void setValid(String newValid) throws PersistenceException;
}
