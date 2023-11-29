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
import generated.kinoService.relationControl.filmPerformanceSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.kinoService.proxies.FilmProxy;
import observation.Observable;
import generated.kinoService.proxies.IFilm;
import src.db.executer.PersistenceException;
import generated.kinoService.relationControl.*;
import java.util.Set;
import java.util.HashSet;
import generated.kinoService.proxies.IPerformance;
import java.util.List;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Film extends Observable implements java.io.Serializable, IFilm
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String titel;
   private String descritpion;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Film(Integer id, String titel, String descritpion, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.titel = titel;
      this.descritpion = descritpion;
      if(objectOnly) return;
   }
   public static Film createFresh(String titel, String descritpion)throws PersistenceException{
      src.db.executer.PersistenceDMLExecuter dmlExecuter = KinoService.getInstance().getDmlExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Film", "id, typeKey, titel, descritpion", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoService", "Film").toString() + ", " + "'" + titel + "'" + ", " + "'" + descritpion + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Film me = new Film(id, titel, descritpion, false);
      KinoService.getInstance().addFilmProxy(new FilmProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoService.getInstance().getFilmCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Film toBeDeleted = KinoService.getInstance().getFilm(id);
      List<IPerformance> ownersInfilmPerformance = filmPerformanceSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInfilmPerformance.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association filmPerformance");
      filmPerformanceSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      KinoService.getInstance().getFilmCache().remove(id);
      KinoService.getInstance().getDmlExecuter().delete("Film", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Film instantiateRuntimeCopy(FilmProxy proxy, String titel, String descritpion){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Film(proxy.getId(), titel, descritpion, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Film getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IFilm)) return false;
      return ((IFilm)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getTitel() {
      return this.titel;
   }
   public void setTitel(String newTitel) throws PersistenceException{
      this.titel = newTitel;
      try{KinoService.getInstance().getDmlExecuter().update("Film", "titel", "'" + newTitel + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getDescritpion() {
      return this.descritpion;
   }
   public void setDescritpion(String newDescritpion) throws PersistenceException{
      this.descritpion = newDescritpion;
      try{KinoService.getInstance().getDmlExecuter().update("Film", "descritpion", "'" + newDescritpion + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Set<Performance> getPerformance() throws PersistenceException{
      Set<Performance> result = new HashSet<>();
      for (IPerformance i : filmPerformanceSupervisor.getInstance().getPerformance(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
/**
 * Liefert die aktuellen Einnahmen für den Film
 */
   public Integer calculateRevenue(){
      Set<Performance> Performances = this.getPerformance();
      int revenueFilm = 0;
      for (Performance performance : Performances) {
    	  revenueFilm += performance.calculateRevenuePerformance();
      }
      return revenueFilm;
   }
//90 ===== GENERATED: End of Your Operations ======
}
