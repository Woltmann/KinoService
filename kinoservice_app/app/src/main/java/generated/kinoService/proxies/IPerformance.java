/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.kinoService.Performance;
import generated.kinoService.Film;
import generated.kinoService.Cinemahall;
import generated.kinoService.Reservation;
import java.util.Set;
import generated.kinoService.Booking;
public interface IPerformance extends Identifiable{
   public Performance getTheObject();
   public Integer getId();
   public Film getFilm() throws PersistenceException;
   public void setFilm(Film newFilm)throws PersistenceException;
   public Cinemahall getAssigendHall() throws PersistenceException;
   public void setAssigendHall(Cinemahall newAssigendHall)throws PersistenceException;
   public Set<Reservation> getReservation() throws PersistenceException;
   public Set<Booking> getBooking() throws PersistenceException;
}
