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
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Tr_EvSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Tr_EvSupervisor theInstance = new Tr_EvSupervisor();
   private Relation<ITransition, IEvent> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Tr_EvSupervisor(){
      this.elements = new Relation<>("Tr_Ev", "StateMachineService");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Tr_EvSupervisor getInstance(){return theInstance;}
   public Relation<ITransition, IEvent> getRelationData() {
      return this.elements;
   }
   public IEvent getEvent(ITransition owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(ITransition owner, IEvent target) throws PersistenceException{
      IEvent targetOld = this.getEvent(owner); IEvent targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(ITransition owner, IEvent target) {
      IEvent targetOld = null; IEvent targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(ITransition owner, IEvent targetOld, IEvent targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
