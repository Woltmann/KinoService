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
import generated.kinoService.proxies.ISeatRow;
import generated.kinoService.relationControl.seRo_CaSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.kinoService.proxies.ILogeService;
import src.db.executer.PersistenceException;
import java.util.Optional;
import java.sql.ResultSet;
import src.idManagement.IDManagerTransient;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class LogeService extends Categorie implements java.io.Serializable, ILogeService
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<LogeService> theInstance = Optional.empty();
   private Optional<Integer> priceSurchargeLogeService;
   private Optional<String> serviceTyp;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private LogeService(Integer id, Optional<Integer> basePrice, Optional<Integer> priceSurchargeLogeService, Optional<String> serviceTyp, boolean objectOnly)
   {
      super(id, basePrice, objectOnly);
      this.priceSurchargeLogeService = priceSurchargeLogeService;
      this.serviceTyp = serviceTyp;
      if(objectOnly) return;
   }
   private static LogeService instantiateRuntimeCopy(Integer id, Optional<Integer> basePrice, Optional<Integer> priceSurchargeLogeService, Optional<String> serviceTyp){
      return new LogeService(id, basePrice, priceSurchargeLogeService, serviceTyp, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static LogeService getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static LogeService load() throws PersistenceException {
      try{
         Integer typeKey = PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoService", "LogeService");
         Optional<ResultSet> rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter("KinoService").selectEntriesOfTable("Categorie", typeKey);
         if(rs.isPresent()) rs.get().next();
         Integer id = rs.isPresent() ? rs.get().getInt("id") : IDManagerTransient.getTheInstance().getNextId();
         Optional<Integer> priceSurchargeLogeService = Optional.empty();
         if(rs.isPresent()) priceSurchargeLogeService = (rs.get().getObject("priceSurchargeLogeService") == null ? Optional.empty() : Optional.of(rs.get().getInt("priceSurchargeLogeService")));
         Optional<String> serviceTyp = Optional.empty();
         if(rs.isPresent()) serviceTyp = (rs.get().getObject("serviceTyp") == null ? Optional.empty() : Optional.of(rs.get().getString("serviceTyp")));
         Optional<Integer> basePrice = Optional.empty();
         if(rs.isPresent()) basePrice = (rs.get().getObject("basePrice") == null ? Optional.empty() : Optional.of(rs.get().getInt("basePrice")));
         return LogeService.instantiateRuntimeCopy(id, basePrice, priceSurchargeLogeService, serviceTyp);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public LogeService getTheObject(){
      return this;
   }
   public Optional<Integer> getPriceSurchargeLogeService() {
      return this.priceSurchargeLogeService;
   }
   public void setPriceSurchargeLogeService(Integer newPriceSurchargeLogeService) throws PersistenceException{
      this.priceSurchargeLogeService = Optional.of(newPriceSurchargeLogeService);
      try{KinoService.getInstance().getDmlExecuter().update("Categorie", "priceSurchargeLogeService", newPriceSurchargeLogeService.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Optional<String> getServiceTyp() {
      return this.serviceTyp;
   }
   public void setServiceTyp(String newServiceTyp) throws PersistenceException{
      this.serviceTyp = Optional.of(newServiceTyp);
      try{KinoService.getInstance().getDmlExecuter().update("Categorie", "serviceTyp", "'" + newServiceTyp + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
   /**
    * Liefert den berechneten Preis für die Kategorie
    */
   @Override
      public Integer calculatePrice(){
	   if (this.getBasePrice().isPresent() && this.getPriceSurchargeLogeService().isPresent()) {
	        return this.getBasePrice().get() + this.getPriceSurchargeLogeService().get();
	    } else {
	        return 0;
	    } 
      }
//90 ===== GENERATED: End of Your Operations ======
}
