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
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class perf_CiHaSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static perf_CiHaSupervisor theInstance = new perf_CiHaSupervisor();
   private Relation<IPerformance, ICinemahall> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private perf_CiHaSupervisor(){
      this.elements = new Relation<>("perf_CiHa", "KinoService");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static perf_CiHaSupervisor getInstance(){return theInstance;}
   public Relation<IPerformance, ICinemahall> getRelationData() {
      return this.elements;
   }
   public ICinemahall getAssigendHall(IPerformance owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IPerformance owner, ICinemahall target) throws PersistenceException{
      ICinemahall targetOld = this.getAssigendHall(owner); ICinemahall targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IPerformance owner, ICinemahall target) {
      ICinemahall targetOld = null; ICinemahall targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IPerformance owner, ICinemahall targetOld, ICinemahall targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
