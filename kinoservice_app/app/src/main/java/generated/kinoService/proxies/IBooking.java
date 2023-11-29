/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.kinoService.Booking;
import generated.kinoService.Client;
import generated.kinoService.Seat;
import java.util.Set;
import generated.kinoService.Performance;
public interface IBooking extends Identifiable{
   public Booking getTheObject();
   public Integer getId();
   public Client getClient() throws PersistenceException;
   public void setClient(Client newClient)throws PersistenceException;
   public Set<Seat> getSeat() throws PersistenceException;
   public void addToSeat(Seat arg) throws PersistenceException;
   public boolean removeFromSeat(Seat arg) throws PersistenceException;
   public Performance getPerformance() throws PersistenceException;
   public void setPerformance(Performance newPerformance)throws PersistenceException;
}
