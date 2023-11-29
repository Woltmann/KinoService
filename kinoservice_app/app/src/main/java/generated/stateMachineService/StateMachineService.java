/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.stateMachineService;
//10 ===== GENERATED: Import Section ==============
import src.db.executer.PersistenceException;
import generated.stateMachineService.relationControl.*;
import utilities.InitialProxyLoader;
import utilities.InitialRelationLoader;
import utilities.InitialRelationLoader.IntegerPair;
import exceptions.ConstraintViolation;
import generated.stateMachineService.proxies.*;
import observation.Observable;
import src.db.executer.PersistenceExecuterFactory;
import src.db.executer.PersistenceDMLExecuter;
import src.db.connection.DBConnectionData;
import java.util.Map;
//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class StateMachineService extends Observable{
   private PersistenceDMLExecuter dmlExecuter;
   private Map<Integer,StateProxy> stateCache;
   private Map<Integer,EventProxy> eventCache;
   private Map<Integer,TransitionProxy> transitionCache;
   private Map<Integer,StateMachineProxy> stateMachineCache;
   private static StateMachineService theInstance = new StateMachineService();
   private StateMachineService(){
      this.dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter("StateMachineService");
      try{
         PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().initializeFor("StateMachineService");
         this.loadProxies();
         this.loadRelations();
      }catch(Exception e){assert false : "Failed to establish initial database connection. Program aborted: " + e.getMessage();}
   }
   public static StateMachineService getInstance(){return theInstance;}
   
// The methods loadProxies/Relations will be replaced by more intelligent lazy-load-strategies!
   private void loadProxies() throws PersistenceException{
      this.stateCache = new InitialProxyLoader<StateProxy>("generated", "StateMachineService", "stateMachineService", "State", "State").perform();
      this.eventCache = new InitialProxyLoader<EventProxy>("generated", "StateMachineService", "stateMachineService", "Event", "Event").perform();
      this.transitionCache = new InitialProxyLoader<TransitionProxy>("generated", "StateMachineService", "stateMachineService", "Transition", "Transition").perform();
      this.stateMachineCache = new InitialProxyLoader<StateMachineProxy>("generated", "StateMachineService", "stateMachineService", "StateMachine", "StateMachine").perform();
   }
   private void loadRelations() throws PersistenceException{
      for(IntegerPair pair : new InitialRelationLoader("Tr_Ev").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Transition");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Event");
         try{this.addTr_EvElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Tr_St_from").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Transition");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "State");
         try{this.addTr_St_fromElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Tr_St_to").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Transition");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "State");
         try{this.addTr_St_toElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("StMachine_Event").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "StateMachine");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Event");
         try{this.addStMachine_EventElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("StM_States").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "StateMachine");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "State");
         try{this.addStM_StatesElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("StM_State").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "StateMachine");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "State");
         try{this.addStM_StateElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("StM_Tr").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "StateMachine");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Transition");
         try{this.addStM_TrElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
   }
   private void addTr_EvElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ITransition proxy1 = null; IEvent proxy2 = null; 
      if(className2.equals("Event"))  proxy2 = this.eventCache.get(id2);
      if(className1.equals("Transition"))  proxy1 = this.transitionCache.get(id1);
      Tr_EvSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addTr_St_fromElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ITransition proxy1 = null; IState proxy2 = null; 
      if(className2.equals("State"))  proxy2 = this.stateCache.get(id2);
      if(className1.equals("Transition"))  proxy1 = this.transitionCache.get(id1);
      Tr_St_fromSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addTr_St_toElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ITransition proxy1 = null; IState proxy2 = null; 
      if(className2.equals("State"))  proxy2 = this.stateCache.get(id2);
      if(className1.equals("Transition"))  proxy1 = this.transitionCache.get(id1);
      Tr_St_toSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addStMachine_EventElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IStateMachine proxy1 = null; IEvent proxy2 = null; 
      if(className2.equals("Event"))  proxy2 = this.eventCache.get(id2);
      if(className1.equals("StateMachine"))  proxy1 = this.stateMachineCache.get(id1);
      StMachine_EventSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addStM_StatesElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IStateMachine proxy1 = null; IState proxy2 = null; 
      if(className2.equals("State"))  proxy2 = this.stateCache.get(id2);
      if(className1.equals("StateMachine"))  proxy1 = this.stateMachineCache.get(id1);
      StM_StatesSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addStM_StateElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IStateMachine proxy1 = null; IState proxy2 = null; 
      if(className2.equals("State"))  proxy2 = this.stateCache.get(id2);
      if(className1.equals("StateMachine"))  proxy1 = this.stateMachineCache.get(id1);
      StM_StateSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addStM_TrElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IStateMachine proxy1 = null; ITransition proxy2 = null; 
      if(className2.equals("Transition"))  proxy2 = this.transitionCache.get(id2);
      if(className1.equals("StateMachine"))  proxy1 = this.stateMachineCache.get(id1);
      StM_TrSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   public State getState(Integer id){
      return this.stateCache.get(id).getTheObject();
   }
   public void addStateProxy(StateProxy p) throws PersistenceException{
      this.stateCache.put(p.getId(), p);
   }
   public Map<Integer,StateProxy> getStateCache(){
      return this.stateCache;
   }
   public Event getEvent(Integer id){
      return this.eventCache.get(id).getTheObject();
   }
   public void addEventProxy(EventProxy p) throws PersistenceException{
      this.eventCache.put(p.getId(), p);
   }
   public Map<Integer,EventProxy> getEventCache(){
      return this.eventCache;
   }
   public Transition getTransition(Integer id){
      return this.transitionCache.get(id).getTheObject();
   }
   public void addTransitionProxy(TransitionProxy p) throws PersistenceException{
      this.transitionCache.put(p.getId(), p);
   }
   public Map<Integer,TransitionProxy> getTransitionCache(){
      return this.transitionCache;
   }
   public StateMachine getStateMachine(Integer id){
      return this.stateMachineCache.get(id).getTheObject();
   }
   public void addStateMachineProxy(StateMachineProxy p) throws PersistenceException{
      this.stateMachineCache.put(p.getId(), p);
   }
   public Map<Integer,StateMachineProxy> getStateMachineCache(){
      return this.stateMachineCache;
   }
   public PersistenceDMLExecuter getDmlExecuter() {
      return this.dmlExecuter;
   }
   public void closeDBConnection() throws java.sql.SQLException{
      PersistenceExecuterFactory.getConfiguredFactory().getDBDDLExecuter().closeConnection("StateMachineService");
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
