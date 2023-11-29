/**--- Generated at Mon Nov 20 23:25:59 CET 2023 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.kinoService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import src.db.executer.PersistenceException;
import generated.kinoService.proxies.*;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class rese_PerfSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static rese_PerfSupervisor theInstance = new rese_PerfSupervisor();
   private Relation<IReservation, IPerformance> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private rese_PerfSupervisor(){
      this.elements = new Relation<>("rese_Perf", "KinoService");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static rese_PerfSupervisor getInstance(){return theInstance;}
   public Relation<IReservation, IPerformance> getRelationData() {
      return this.elements;
   }
   public IPerformance getPerformance(IReservation owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IReservation owner, IPerformance target) throws PersistenceException{
      IPerformance targetOld = this.getPerformance(owner); IPerformance targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IReservation owner, IPerformance target) {
      IPerformance targetOld = null; IPerformance targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IReservation owner, IPerformance targetOld, IPerformance targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
