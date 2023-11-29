/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.kinoService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import src.db.connection.NoConnectionException;
import src.db.executer.PersistenceExecuterFactory;
import exceptions.ConstraintViolation;
import java.util.List;
import generated.kinoService.proxies.IPerformance;
import generated.kinoService.relationControl.perf_CiHaSupervisor;
import generated.kinoService.relationControl.CiHa_SeRoSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.kinoService.proxies.CinemahallProxy;
import observation.Observable;
import generated.kinoService.proxies.ICinemahall;
import generated.kinoService.relationControl.*;
import generated.kinoService.proxies.*;
import src.db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Cinemahall extends Observable implements java.io.Serializable, ICinemahall
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String hallname;
   private Boolean isFree;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Cinemahall(Integer id, String hallname, Boolean isFree, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.hallname = hallname;
      this.isFree = isFree;
      if(objectOnly) return;
   }
   public static Cinemahall createFresh(String hallname, Boolean isFree)throws PersistenceException{
      src.db.executer.PersistenceDMLExecuter dmlExecuter = KinoService.getInstance().getDmlExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Cinemahall", "id, typeKey, hallname, isFree", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoService", "Cinemahall").toString() + ", " + "'" + hallname + "'" + ", " + isFree.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Cinemahall me = new Cinemahall(id, hallname, isFree, false);
      KinoService.getInstance().addCinemahallProxy(new CinemahallProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoService.getInstance().getCinemahallCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Cinemahall toBeDeleted = KinoService.getInstance().getCinemahall(id);
      List<IPerformance> ownersInperf_CiHa = perf_CiHaSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInperf_CiHa.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association perf_CiHa");
      perf_CiHaSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      CiHa_SeRoSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KinoService.getInstance().getCinemahallCache().remove(id);
      KinoService.getInstance().getDmlExecuter().delete("Cinemahall", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Cinemahall instantiateRuntimeCopy(CinemahallProxy proxy, String hallname, Boolean isFree){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Cinemahall(proxy.getId(), hallname, isFree, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Cinemahall getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ICinemahall)) return false;
      return ((ICinemahall)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Set<SeatRow> getSeatRow() throws PersistenceException{
      Set<SeatRow> result = new HashSet<>();
      for (ISeatRow i : CiHa_SeRoSupervisor.getInstance().getSeatRow(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToSeatRow(SeatRow arg) throws PersistenceException{
      CiHa_SeRoSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromSeatRow(SeatRow arg) throws PersistenceException{
      return CiHa_SeRoSupervisor.getInstance().remove(this, arg);
   }
   public String getHallname() {
      return this.hallname;
   }
   public void setHallname(String newHallname) throws PersistenceException{
      this.hallname = newHallname;
      try{KinoService.getInstance().getDmlExecuter().update("Cinemahall", "hallname", "'" + newHallname + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Boolean getIsFree() {
      return this.isFree;
   }
   public void setIsFree(Boolean newIsFree) throws PersistenceException{
      this.isFree = newIsFree;
      try{KinoService.getInstance().getDmlExecuter().update("Cinemahall", "isFree", newIsFree.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
