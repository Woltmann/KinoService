/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import src.db.executer.PersistenceException;
import java.util.Optional;
import generated.stateMachineService.StateMachineService;
import src.db.executer.*;
import generated.stateMachineService.Transition;
import java.sql.ResultSet;
import java.util.Optional;
import generated.stateMachineService.Event;
import generated.stateMachineService.relationControl.Tr_EvSupervisor;
import generated.stateMachineService.State;
import generated.stateMachineService.relationControl.Tr_St_fromSupervisor;
import generated.stateMachineService.relationControl.Tr_St_toSupervisor;
import generated.stateMachineService.StateMachine;
import generated.stateMachineService.relationControl.StM_TrSupervisor;
public class TransitionProxy implements ITransition{
   private Integer id;
   private Optional<Transition> theObject;
   public TransitionProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public TransitionProxy(Transition theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Transition getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Transition";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ITransition)) return false;
      return ((ITransition)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Transition load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = StateMachineService.getInstance().getDmlExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Transition", this.id);
         Event event = Tr_EvSupervisor.getInstance().getEvent(this).getTheObject();
         State from = Tr_St_fromSupervisor.getInstance().getFrom(this).getTheObject();
         State to = Tr_St_toSupervisor.getInstance().getTo(this).getTheObject();
         StateMachine myStateMachine = StM_TrSupervisor.getInstance().getMyStateMachine(this).getTheObject();
         return Transition.instantiateRuntimeCopy(this, event, from, to, myStateMachine);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Event getEvent() throws PersistenceException{
      return this.getTheObject().getEvent();
   }
   public void setEvent(Event newEvent)throws PersistenceException{
      this.getTheObject().setEvent(newEvent);
   }
   public State getFrom() throws PersistenceException{
      return this.getTheObject().getFrom();
   }
   public void setFrom(State newFrom)throws PersistenceException{
      this.getTheObject().setFrom(newFrom);
   }
   public State getTo() throws PersistenceException{
      return this.getTheObject().getTo();
   }
   public void setTo(State newTo)throws PersistenceException{
      this.getTheObject().setTo(newTo);
   }
   public StateMachine getMyStateMachine() throws PersistenceException{
      return this.getTheObject().getMyStateMachine();
   }
}
