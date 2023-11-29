/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.stateMachineService.Event;
public interface IEvent extends Identifiable{
   public Event getTheObject();
   public Integer getId();
   public String getLabel() ;
   public void setLabel(String newLabel) throws PersistenceException;
}
