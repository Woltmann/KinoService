/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import src.db.executer.PersistenceException;
import java.util.Optional;
import generated.stateMachineService.StateMachineService;
import src.db.executer.*;
import generated.stateMachineService.StateMachine;
import java.sql.ResultSet;
import java.util.Optional;
import generated.stateMachineService.Event;
import java.util.Set;
import generated.stateMachineService.State;
import generated.stateMachineService.relationControl.StM_StateSupervisor;
import generated.stateMachineService.Transition;
import exceptions.ConstraintViolation;
public class StateMachineProxy implements IStateMachine{
   private Integer id;
   private Optional<StateMachine> theObject;
   public StateMachineProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public StateMachineProxy(StateMachine theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public StateMachine getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "StateMachine";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IStateMachine)) return false;
      return ((IStateMachine)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private StateMachine load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = StateMachineService.getInstance().getDmlExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("StateMachine", this.id);
         State startState = StM_StateSupervisor.getInstance().getStartState(this).getTheObject();
         return StateMachine.instantiateRuntimeCopy(this, startState);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Set<Event> getEvents() throws PersistenceException{
      return this.getTheObject().getEvents();
   }
   public void addToEvents(Event arg) throws PersistenceException{
      this.getTheObject().addToEvents(arg);
   }
   public boolean removeFromEvents(Event arg) throws PersistenceException{
      return this.getTheObject().removeFromEvents(arg);
   }
   public Set<State> getStates() throws PersistenceException{
      return this.getTheObject().getStates();
   }
   public void addToStates(State arg) throws PersistenceException{
      this.getTheObject().addToStates(arg);
   }
   public boolean removeFromStates(State arg) throws PersistenceException{
      return this.getTheObject().removeFromStates(arg);
   }
   public State getStartState() throws PersistenceException{
      return this.getTheObject().getStartState();
   }
   public void setStartState(State newStartState)throws PersistenceException{
      this.getTheObject().setStartState(newStartState);
   }
   public Set<Transition> getTransitions() throws PersistenceException{
      return this.getTheObject().getTransitions();
   }
   public void addToTransitions(Transition arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToTransitions(arg);
   }
   public boolean removeFromTransitions(Transition arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromTransitions(arg);
   }
   public Boolean isDeterministic(String W){
      return this.getTheObject().isDeterministic(W);
   }
}
