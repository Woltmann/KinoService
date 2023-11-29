/**--- Generated at Fri Nov 24 20:30:04 CET 2023 
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
import exceptions.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class reservationPerformanceSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static reservationPerformanceSupervisor theInstance = new reservationPerformanceSupervisor();
   private Relation<IReservation, IPerformance> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private reservationPerformanceSupervisor(){
      this.elements = new Relation<>("reservationPerformance", "KinoService");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static reservationPerformanceSupervisor getInstance(){return theInstance;}
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
   public Set<IReservation> getReservation(IPerformance target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
