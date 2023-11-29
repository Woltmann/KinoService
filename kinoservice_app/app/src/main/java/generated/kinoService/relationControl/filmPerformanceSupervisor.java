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
import exceptions.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class filmPerformanceSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static filmPerformanceSupervisor theInstance = new filmPerformanceSupervisor();
   private Relation<IPerformance, IFilm> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private filmPerformanceSupervisor(){
      this.elements = new Relation<>("filmPerformance", "KinoService");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static filmPerformanceSupervisor getInstance(){return theInstance;}
   public Relation<IPerformance, IFilm> getRelationData() {
      return this.elements;
   }
   public IFilm getFilm(IPerformance owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IPerformance owner, IFilm target) throws PersistenceException{
      IFilm targetOld = this.getFilm(owner); IFilm targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IPerformance owner, IFilm target) {
      IFilm targetOld = null; IFilm targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IPerformance owner, IFilm targetOld, IFilm targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   public Set<IPerformance> getPerformance(IFilm target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
