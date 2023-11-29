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
public class seatRowSeatSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static seatRowSeatSupervisor theInstance = new seatRowSeatSupervisor();
   private Relation<ISeat, ISeatRow> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private seatRowSeatSupervisor(){
      this.elements = new Relation<>("seatRowSeat", "KinoService");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static seatRowSeatSupervisor getInstance(){return theInstance;}
   public Relation<ISeat, ISeatRow> getRelationData() {
      return this.elements;
   }
   public ISeatRow getSeatRow(ISeat owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(ISeat owner, ISeatRow target) throws PersistenceException{
      ISeatRow targetOld = this.getSeatRow(owner); ISeatRow targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(ISeat owner, ISeatRow target) {
      ISeatRow targetOld = null; ISeatRow targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(ISeat owner, ISeatRow targetOld, ISeatRow targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   public Set<ISeat> getSeat(ISeatRow target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
