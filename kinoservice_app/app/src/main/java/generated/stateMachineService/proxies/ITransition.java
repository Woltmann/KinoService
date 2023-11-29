/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.stateMachineService.Transition;
import generated.stateMachineService.Event;
import generated.stateMachineService.State;
import generated.stateMachineService.StateMachine;
public interface ITransition extends Identifiable{
   public Transition getTheObject();
   public Integer getId();
   public Event getEvent() throws PersistenceException;
   public void setEvent(Event newEvent)throws PersistenceException;
   public State getFrom() throws PersistenceException;
   public void setFrom(State newFrom)throws PersistenceException;
   public State getTo() throws PersistenceException;
   public void setTo(State newTo)throws PersistenceException;
   public StateMachine getMyStateMachine() throws PersistenceException;
}
