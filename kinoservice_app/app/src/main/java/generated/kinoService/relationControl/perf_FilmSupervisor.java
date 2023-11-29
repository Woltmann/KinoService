/**--- Generated at Sat Nov 18 15:40:51 CET 2023 
 * --- Mode = No Database 
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
public class perf_FilmSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static perf_FilmSupervisor theInstance = new perf_FilmSupervisor();
   private Relation<IPerformance, IFilm> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private perf_FilmSupervisor(){
      this.elements = new Relation<>("perf_Film", "KinoService");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static perf_FilmSupervisor getInstance(){return theInstance;}
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
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
