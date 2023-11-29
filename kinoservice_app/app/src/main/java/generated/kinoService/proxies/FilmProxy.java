/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.db.executer.PersistenceException;
import java.util.Optional;
import generated.kinoService.KinoService;
import src.db.executer.*;
import generated.kinoService.Film;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoService.Performance;
import java.util.Set;
public class FilmProxy implements IFilm{
   private Integer id;
   private Optional<Film> theObject;
   public FilmProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public FilmProxy(Film theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Film getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Film";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IFilm)) return false;
      return ((IFilm)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Film load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = KinoService.getInstance().getDmlExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Film", this.id);
         String titel = rs.get().getString("titel");
         String descritpion = rs.get().getString("descritpion");
         return Film.instantiateRuntimeCopy(this, titel, descritpion);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getTitel() {
      return this.getTheObject().getTitel();
   }
   public void setTitel(String newTitel) throws PersistenceException{
      this.getTheObject().setTitel(newTitel);
   }
   public String getDescritpion() {
      return this.getTheObject().getDescritpion();
   }
   public void setDescritpion(String newDescritpion) throws PersistenceException{
      this.getTheObject().setDescritpion(newDescritpion);
   }
   public Set<Performance> getPerformance() throws PersistenceException{
      return this.getTheObject().getPerformance();
   }
}
