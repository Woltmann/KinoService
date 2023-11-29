/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.stateMachineService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import src.db.executer.PersistenceException;
import generated.stateMachineService.proxies.*;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class StMachine_EventSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static StMachine_EventSupervisor theInstance = new StMachine_EventSupervisor();
   private Relation<IStateMachine, IEvent> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private StMachine_EventSupervisor(){
      this.elements = new Relation<>("StMachine_Event", "StateMachineService");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static StMachine_EventSupervisor getInstance(){return theInstance;}
   public Relation<IStateMachine, IEvent> getRelationData() {
      return this.elements;
   }
   public Set<IEvent> getEvents(IStateMachine owner){
      return this.elements.getRelatedTargets(owner).stream().collect(Collectors.toSet());
   }
   public void add(IStateMachine owner, IEvent target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   /** Used only by service class !! **/
   public void addAlreadyPersistent(IStateMachine owner, IEvent target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(IStateMachine owner, IEvent target) throws PersistenceException{
      boolean loop = this.removeOnce(owner, target);
      boolean result = loop;
      while(loop) loop = this.removeOnce(owner, target);
      return result;
   }
   private boolean removeOnce(IStateMachine owner, IEvent target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
