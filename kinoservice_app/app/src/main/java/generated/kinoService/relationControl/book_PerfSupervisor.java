/**--- Generated at Mon Nov 20 23:26:00 CET 2023 
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
public class book_PerfSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static book_PerfSupervisor theInstance = new book_PerfSupervisor();
   private Relation<IBooking, IPerformance> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private book_PerfSupervisor(){
      this.elements = new Relation<>("book_Perf", "KinoService");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static book_PerfSupervisor getInstance(){return theInstance;}
   public Relation<IBooking, IPerformance> getRelationData() {
      return this.elements;
   }
   public IPerformance getPerformence(IBooking owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IBooking owner, IPerformance target) throws PersistenceException{
      IPerformance targetOld = this.getPerformence(owner); IPerformance targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IBooking owner, IPerformance target) {
      IPerformance targetOld = null; IPerformance targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IBooking owner, IPerformance targetOld, IPerformance targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
