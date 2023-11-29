/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.stateMachineService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import src.db.connection.NoConnectionException;
import src.db.executer.PersistenceExecuterFactory;
import exceptions.ConstraintViolation;
import generated.stateMachineService.relationControl.StM_TrSupervisor;
import generated.stateMachineService.relationControl.Tr_EvSupervisor;
import generated.stateMachineService.relationControl.Tr_St_fromSupervisor;
import generated.stateMachineService.relationControl.Tr_St_toSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.stateMachineService.proxies.TransitionProxy;
import observation.Observable;
import generated.stateMachineService.proxies.ITransition;
import generated.stateMachineService.relationControl.*;
import generated.stateMachineService.proxies.*;
import src.db.executer.PersistenceException;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Transition extends Observable implements java.io.Serializable, ITransition
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Transition(Integer id, Event event, State from, State to, StateMachine myStateMachine, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      Tr_EvSupervisor.getInstance().set(this, event);
      Tr_St_fromSupervisor.getInstance().set(this, from);
      Tr_St_toSupervisor.getInstance().set(this, to);
      if(objectOnly) return;
      try{StM_TrSupervisor.getInstance().add(myStateMachine,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static Transition createFresh(Event event, State from, State to, StateMachine myStateMachine)throws PersistenceException{
      src.db.executer.PersistenceDMLExecuter dmlExecuter = StateMachineService.getInstance().getDmlExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Transition", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("StateMachineService", "Transition").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Transition me = new Transition(id, event, from, to, myStateMachine, false);
      StateMachineService.getInstance().addTransitionProxy(new TransitionProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!StateMachineService.getInstance().getTransitionCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Transition toBeDeleted = StateMachineService.getInstance().getTransition(id);
      StM_TrSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      Tr_EvSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      Tr_St_fromSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      Tr_St_toSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      StateMachineService.getInstance().getTransitionCache().remove(id);
      StateMachineService.getInstance().getDmlExecuter().delete("Transition", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Transition instantiateRuntimeCopy(TransitionProxy proxy, Event event, State from, State to, StateMachine myStateMachine)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Transition(proxy.getId(), event, from, to, myStateMachine, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Transition getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ITransition)) return false;
      return ((ITransition)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Event getEvent() throws PersistenceException{
      return Tr_EvSupervisor.getInstance().getEvent(this).getTheObject();
   }
   public void setEvent(Event newEvent)throws PersistenceException{
      Tr_EvSupervisor.getInstance().change(this, this.getEvent(), newEvent);
   }
   public State getFrom() throws PersistenceException{
      return Tr_St_fromSupervisor.getInstance().getFrom(this).getTheObject();
   }
   public void setFrom(State newFrom)throws PersistenceException{
      Tr_St_fromSupervisor.getInstance().change(this, this.getFrom(), newFrom);
   }
   public State getTo() throws PersistenceException{
      return Tr_St_toSupervisor.getInstance().getTo(this).getTheObject();
   }
   public void setTo(State newTo)throws PersistenceException{
      Tr_St_toSupervisor.getInstance().change(this, this.getTo(), newTo);
   }
   public StateMachine getMyStateMachine() throws PersistenceException{
      return StM_TrSupervisor.getInstance().getMyStateMachine(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
