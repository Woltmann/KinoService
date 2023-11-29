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
import generated.stateMachineService.relationControl.StMachine_EventSupervisor;
import generated.stateMachineService.relationControl.StM_StatesSupervisor;
import generated.stateMachineService.relationControl.StM_StateSupervisor;
import java.util.List;
import generated.stateMachineService.proxies.ITransition;
import generated.stateMachineService.relationControl.StM_TrSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.stateMachineService.proxies.StateMachineProxy;
import observation.Observable;
import generated.stateMachineService.proxies.IStateMachine;
import generated.stateMachineService.relationControl.*;
import generated.stateMachineService.proxies.*;
import src.db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class StateMachine extends Observable implements java.io.Serializable, IStateMachine
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private StateMachine(Integer id, State startState, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      StM_StateSupervisor.getInstance().set(this, startState);
      if(objectOnly) return;
   }
   public static StateMachine createFresh(State startState)throws PersistenceException{
      src.db.executer.PersistenceDMLExecuter dmlExecuter = StateMachineService.getInstance().getDmlExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("StateMachine", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("StateMachineService", "StateMachine").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      StateMachine me = new StateMachine(id, startState, false);
      StateMachineService.getInstance().addStateMachineProxy(new StateMachineProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!StateMachineService.getInstance().getStateMachineCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      StateMachine toBeDeleted = StateMachineService.getInstance().getStateMachine(id);
      StMachine_EventSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      StM_StatesSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      StM_StateSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      List<ITransition> targetsInStM_Tr = StM_TrSupervisor.getInstance().getRelationData().getRelatedTargets(toBeDeleted);
      if(targetsInStM_Tr.size()>0) throw new ConstraintViolation(" Deletion not possible: Object still contains other objects in Association StM_Tr");
      StM_TrSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      StateMachineService.getInstance().getStateMachineCache().remove(id);
      StateMachineService.getInstance().getDmlExecuter().delete("StateMachine", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static StateMachine instantiateRuntimeCopy(StateMachineProxy proxy, State startState)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new StateMachine(proxy.getId(), startState, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public StateMachine getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IStateMachine)) return false;
      return ((IStateMachine)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Set<Event> getEvents() throws PersistenceException{
      Set<Event> result = new HashSet<>();
      for (IEvent i : StMachine_EventSupervisor.getInstance().getEvents(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToEvents(Event arg) throws PersistenceException{
      StMachine_EventSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromEvents(Event arg) throws PersistenceException{
      return StMachine_EventSupervisor.getInstance().remove(this, arg);
   }
   public Set<State> getStates() throws PersistenceException{
      Set<State> result = new HashSet<>();
      for (IState i : StM_StatesSupervisor.getInstance().getStates(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToStates(State arg) throws PersistenceException{
      StM_StatesSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromStates(State arg) throws PersistenceException{
      return StM_StatesSupervisor.getInstance().remove(this, arg);
   }
   public State getStartState() throws PersistenceException{
      return StM_StateSupervisor.getInstance().getStartState(this).getTheObject();
   }
   public void setStartState(State newStartState)throws PersistenceException{
      StM_StateSupervisor.getInstance().change(this, this.getStartState(), newStartState);
   }
   public Set<Transition> getTransitions() throws PersistenceException{
      Set<Transition> result = new HashSet<>();
      for (ITransition i : StM_TrSupervisor.getInstance().getTransitions(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToTransitions(Transition arg) throws ConstraintViolation, PersistenceException{
      StM_TrSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromTransitions(Transition arg) throws ConstraintViolation, PersistenceException{
      return StM_TrSupervisor.getInstance().remove(this, arg);
   }
   //80 ===== Editable : Your Operations =============
/**
 * Liefert true genau dann wenn w vom Automaten erkannt wird
 */
   public Boolean validate(String w){
      // TODO: Implement Operation validate
      return null;
   }
/**
 * Liefert true genau dann, wenn der Automat deterministisch ist.
 */
   public Boolean isDeterministic(String W){
	   Set<Transition> transitions = getTransitions();
	    
	    for (Transition transition : transitions) {
	        State fromState = transition.getFrom();
	        Event event = transition.getEvent();
	        
	        // Zählen, wie oft der Übergang von fromState mit event vorkommt
	        long count = transitions.stream()
	                .filter(t ->
	                        t.getFrom().equals(fromState) &&
	                        t.getEvent().equals(event))
	                .count();

	        // Wenn der Übergang mehr als einmal vorkommt, ist der Automat nicht-deterministisch
	        if (count > 1) {
	            return false;
	        }
	    }
	    
	    return true;
   }
//90 ===== GENERATED: End of Your Operations ======
}
