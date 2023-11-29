/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.stateMachineService.StateMachine;
import generated.stateMachineService.Event;
import java.util.Set;
import generated.stateMachineService.State;
import generated.stateMachineService.Transition;
import exceptions.ConstraintViolation;
public interface IStateMachine extends Identifiable{
   public StateMachine getTheObject();
   public Integer getId();
   public Set<Event> getEvents() throws PersistenceException;
   public void addToEvents(Event arg) throws PersistenceException;
   public boolean removeFromEvents(Event arg) throws PersistenceException;
   public Set<State> getStates() throws PersistenceException;
   public void addToStates(State arg) throws PersistenceException;
   public boolean removeFromStates(State arg) throws PersistenceException;
   public State getStartState() throws PersistenceException;
   public void setStartState(State newStartState)throws PersistenceException;
   public Set<Transition> getTransitions() throws PersistenceException;
   public void addToTransitions(Transition arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromTransitions(Transition arg) throws ConstraintViolation, PersistenceException;
   public Boolean isDeterministic(String W);
}
