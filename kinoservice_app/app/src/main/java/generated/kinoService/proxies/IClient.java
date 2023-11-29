/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.kinoService.Client;
import generated.kinoService.Reservation;
import java.util.Set;
import generated.kinoService.Booking;
public interface IClient extends Identifiable{
   public Client getTheObject();
   public Integer getId();
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
   public String getEmail() ;
   public void setEmail(String newEmail) throws PersistenceException;
   public Set<Reservation> getReservation() throws PersistenceException;
   public Set<Booking> getBooking() throws PersistenceException;
}
