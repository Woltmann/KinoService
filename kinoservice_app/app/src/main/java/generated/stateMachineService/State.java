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
import java.util.List;
import generated.stateMachineService.proxies.ITransition;
import generated.stateMachineService.relationControl.Tr_St_fromSupervisor;
import generated.stateMachineService.relationControl.Tr_St_toSupervisor;
import generated.stateMachineService.relationControl.StM_StatesSupervisor;
import generated.stateMachineService.proxies.IStateMachine;
import generated.stateMachineService.relationControl.StM_StateSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.stateMachineService.proxies.StateProxy;
import observation.Observable;
import generated.stateMachineService.proxies.IState;
import src.db.executer.PersistenceException;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class State extends Observable implements java.io.Serializable, IState
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String name;
   private Boolean isFinal;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private State(Integer id, String name, Boolean isFinal, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.name = name;
      this.isFinal = isFinal;
      if(objectOnly) return;
   }
   public static State createFresh(String name, Boolean isFinal)throws PersistenceException{
      src.db.executer.PersistenceDMLExecuter dmlExecuter = StateMachineService.getInstance().getDmlExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("State", "id, typeKey, name, isFinal", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("StateMachineService", "State").toString() + ", " + "'" + name + "'" + ", " + isFinal.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      State me = new State(id, name, isFinal, false);
      StateMachineService.getInstance().addStateProxy(new StateProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!StateMachineService.getInstance().getStateCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      State toBeDeleted = StateMachineService.getInstance().getState(id);
      List<ITransition> ownersInTr_St_from = Tr_St_fromSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInTr_St_from.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association Tr_St_from");
      Tr_St_fromSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      List<ITransition> ownersInTr_St_to = Tr_St_toSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInTr_St_to.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association Tr_St_to");
      Tr_St_toSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      StM_StatesSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      List<IStateMachine> ownersInStM_State = StM_StateSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInStM_State.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association StM_State");
      StM_StateSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      StateMachineService.getInstance().getStateCache().remove(id);
      StateMachineService.getInstance().getDmlExecuter().delete("State", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static State instantiateRuntimeCopy(StateProxy proxy, String name, Boolean isFinal){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new State(proxy.getId(), name, isFinal, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public State getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IState)) return false;
      return ((IState)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = newName;
      try{StateMachineService.getInstance().getDmlExecuter().update("State", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Boolean getIsFinal() {
      return this.isFinal;
   }
   public void setIsFinal(Boolean newIsFinal) throws PersistenceException{
      this.isFinal = newIsFinal;
      try{StateMachineService.getInstance().getDmlExecuter().update("State", "isFinal", newIsFinal.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
