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
public class bookingClientSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static bookingClientSupervisor theInstance = new bookingClientSupervisor();
   private Relation<IBooking, IClient> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private bookingClientSupervisor(){
      this.elements = new Relation<>("bookingClient", "KinoService");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static bookingClientSupervisor getInstance(){return theInstance;}
   public Relation<IBooking, IClient> getRelationData() {
      return this.elements;
   }
   public IClient getClient(IBooking owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IBooking owner, IClient target) throws PersistenceException{
      IClient targetOld = this.getClient(owner); IClient targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IBooking owner, IClient target) {
      IClient targetOld = null; IClient targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IBooking owner, IClient targetOld, IClient targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   public Set<IBooking> getBooking(IClient target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
