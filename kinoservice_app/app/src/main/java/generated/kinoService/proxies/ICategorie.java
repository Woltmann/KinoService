/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.kinoService.Categorie;
import java.util.Optional;
public interface ICategorie extends Identifiable{
   public Categorie getTheObject();
   public Optional<Integer> getBasePrice() ;
   public void setBasePrice(Integer newBasePrice) throws PersistenceException;
}
