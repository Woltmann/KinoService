/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.kinoService.Seat;
import generated.kinoService.SeatRow;
public interface ISeat extends Identifiable{
   public Seat getTheObject();
   public Integer getId();
   public SeatRow getSeatRow() throws PersistenceException;
   public void setSeatRow(SeatRow newSeatRow)throws PersistenceException;
}
