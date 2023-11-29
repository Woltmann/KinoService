/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.kinoService.Cinemahall;
import generated.kinoService.SeatRow;
import java.util.Set;
public interface ICinemahall extends Identifiable{
   public Cinemahall getTheObject();
   public Integer getId();
   public Set<SeatRow> getSeatRow() throws PersistenceException;
   public void addToSeatRow(SeatRow arg) throws PersistenceException;
   public boolean removeFromSeatRow(SeatRow arg) throws PersistenceException;
   public String getHallname() ;
   public void setHallname(String newHallname) throws PersistenceException;
   public Boolean getIsFree() ;
   public void setIsFree(Boolean newIsFree) throws PersistenceException;
}
