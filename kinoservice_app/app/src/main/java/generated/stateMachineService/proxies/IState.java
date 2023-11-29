/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.stateMachineService.State;
public interface IState extends Identifiable{
   public State getTheObject();
   public Integer getId();
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
   public Boolean getIsFinal() ;
   public void setIsFinal(Boolean newIsFinal) throws PersistenceException;
}
