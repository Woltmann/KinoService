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
import generated.stateMachineService.relationControl.Tr_EvSupervisor;
import generated.stateMachineService.relationControl.StMachine_EventSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.stateMachineService.proxies.EventProxy;
import observation.Observable;
import generated.stateMachineService.proxies.IEvent;
import src.db.executer.PersistenceException;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Event extends Observable implements java.io.Serializable, IEvent
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String label;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Event(Integer id, String label, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.label = label;
      if(objectOnly) return;
   }
   public static Event createFresh(String label)throws PersistenceException{
      src.db.executer.PersistenceDMLExecuter dmlExecuter = StateMachineService.getInstance().getDmlExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Event", "id, typeKey, label", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("StateMachineService", "Event").toString() + ", " + "'" + label + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Event me = new Event(id, label, false);
      StateMachineService.getInstance().addEventProxy(new EventProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!StateMachineService.getInstance().getEventCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Event toBeDeleted = StateMachineService.getInstance().getEvent(id);
      List<ITransition> ownersInTr_Ev = Tr_EvSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInTr_Ev.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association Tr_Ev");
      Tr_EvSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      StMachine_EventSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      StateMachineService.getInstance().getEventCache().remove(id);
      StateMachineService.getInstance().getDmlExecuter().delete("Event", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Event instantiateRuntimeCopy(EventProxy proxy, String label){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Event(proxy.getId(), label, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Event getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IEvent)) return false;
      return ((IEvent)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getLabel() {
      return this.label;
   }
   public void setLabel(String newLabel) throws PersistenceException{
      this.label = newLabel;
      try{StateMachineService.getInstance().getDmlExecuter().update("Event", "label", "'" + newLabel + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
