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
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class seRo_CaSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static seRo_CaSupervisor theInstance = new seRo_CaSupervisor();
   private Relation<ISeatRow, ICategorie> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private seRo_CaSupervisor(){
      this.elements = new Relation<>("seRo_Ca", "KinoService");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static seRo_CaSupervisor getInstance(){return theInstance;}
   public Relation<ISeatRow, ICategorie> getRelationData() {
      return this.elements;
   }
   public ICategorie getCategorie(ISeatRow owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(ISeatRow owner, ICategorie target) throws PersistenceException{
      ICategorie targetOld = this.getCategorie(owner); ICategorie targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(ISeatRow owner, ICategorie target) {
      ICategorie targetOld = null; ICategorie targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(ISeatRow owner, ICategorie targetOld, ICategorie targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
