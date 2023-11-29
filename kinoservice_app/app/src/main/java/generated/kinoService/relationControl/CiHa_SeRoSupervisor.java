/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
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
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class CiHa_SeRoSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static CiHa_SeRoSupervisor theInstance = new CiHa_SeRoSupervisor();
   private Relation<ICinemahall, ISeatRow> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private CiHa_SeRoSupervisor(){
      this.elements = new Relation<>("CiHa_SeRo", "KinoService");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static CiHa_SeRoSupervisor getInstance(){return theInstance;}
   public Relation<ICinemahall, ISeatRow> getRelationData() {
      return this.elements;
   }
   public Set<ISeatRow> getSeatRow(ICinemahall owner){
      return this.elements.getRelatedTargets(owner).stream().collect(Collectors.toSet());
   }
   public void add(ICinemahall owner, ISeatRow target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   /** Used only by service class !! **/
   public void addAlreadyPersistent(ICinemahall owner, ISeatRow target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(ICinemahall owner, ISeatRow target) throws PersistenceException{
      boolean loop = this.removeOnce(owner, target);
      boolean result = loop;
      while(loop) loop = this.removeOnce(owner, target);
      return result;
   }
   private boolean removeOnce(ICinemahall owner, ISeatRow target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
