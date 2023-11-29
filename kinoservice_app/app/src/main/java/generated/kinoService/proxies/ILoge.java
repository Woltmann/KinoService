/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.kinoService.Loge;
import java.util.Optional;
public interface ILoge extends ICategorie{
   public Loge getTheObject();
   public Integer getId();
   public Optional<Integer> getPriceSurchargeLoge() ;
   public void setPriceSurchargeLoge(Integer newPriceSurchargeLoge) throws PersistenceException;
}
