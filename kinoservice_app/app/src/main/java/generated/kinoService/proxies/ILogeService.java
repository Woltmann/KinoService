/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.idManagement.Identifiable;
import src.db.executer.PersistenceException;
import generated.kinoService.LogeService;
import java.util.Optional;
public interface ILogeService extends ICategorie{
   public LogeService getTheObject();
   public Integer getId();
   public Optional<Integer> getPriceSurchargeLogeService() ;
   public void setPriceSurchargeLogeService(Integer newPriceSurchargeLogeService) throws PersistenceException;
   public Optional<String> getServiceTyp() ;
   public void setServiceTyp(String newServiceTyp) throws PersistenceException;
}
