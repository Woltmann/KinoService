/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.kinoService.Film;
import generated.kinoService.Performance;
import java.util.Set;
public interface IFilm extends Identifiable{
   public Film getTheObject();
   public Integer getId();
   public String getTitel() ;
   public void setTitel(String newTitel) throws PersistenceException;
   public String getDescritpion() ;
   public void setDescritpion(String newDescritpion) throws PersistenceException;
   public Set<Performance> getPerformance() throws PersistenceException;
}
