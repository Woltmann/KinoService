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
import generated.kinoService.proxies.ILoge;
import src.db.executer.PersistenceException;
import java.util.Optional;
import java.sql.ResultSet;
import src.idManagement.IDManagerTransient;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Loge extends Categorie implements java.io.Serializable, ILoge
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<Loge> theInstance = Optional.empty();
   private Optional<Integer> priceSurchargeLoge;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Loge(Integer id, Optional<Integer> basePrice, Optional<Integer> priceSurchargeLoge, boolean objectOnly)
   {
      super(id, basePrice, objectOnly);
      this.priceSurchargeLoge = priceSurchargeLoge;
      if(objectOnly) return;
   }
   private static Loge instantiateRuntimeCopy(Integer id, Optional<Integer> basePrice, Optional<Integer> priceSurchargeLoge){
      return new Loge(id, basePrice, priceSurchargeLoge, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Loge getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Loge load() throws PersistenceException {
      try{
         Integer typeKey = PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoService", "Loge");
         Optional<ResultSet> rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter("KinoService").selectEntriesOfTable("Categorie", typeKey);
         if(rs.isPresent()) rs.get().next();
         Integer id = rs.isPresent() ? rs.get().getInt("id") : IDManagerTransient.getTheInstance().getNextId();
         Optional<Integer> priceSurchargeLoge = Optional.empty();
         if(rs.isPresent()) priceSurchargeLoge = (rs.get().getObject("priceSurchargeLoge") == null ? Optional.empty() : Optional.of(rs.get().getInt("priceSurchargeLoge")));
         Optional<Integer> basePrice = Optional.empty();
         if(rs.isPresent()) basePrice = (rs.get().getObject("basePrice") == null ? Optional.empty() : Optional.of(rs.get().getInt("basePrice")));
         return Loge.instantiateRuntimeCopy(id, basePrice, priceSurchargeLoge);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Loge getTheObject(){
      return this;
   }
   public Optional<Integer> getPriceSurchargeLoge() {
      return this.priceSurchargeLoge;
   }
   public void setPriceSurchargeLoge(Integer newPriceSurchargeLoge) throws PersistenceException{
      this.priceSurchargeLoge = Optional.of(newPriceSurchargeLoge);
      try{KinoService.getInstance().getDmlExecuter().update("Categorie", "priceSurchargeLoge", newPriceSurchargeLoge.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
   /**
    * Liefert den berechneten Preis für die Kategorie
    */
   @Override
      public Integer calculatePrice(){
	   if (this.getBasePrice().isPresent() && this.getPriceSurchargeLoge().isPresent()) {
	        return this.getBasePrice().get() + this.getPriceSurchargeLoge().get();
	    } else {
	        return 0;
	    } 
      }
//90 ===== GENERATED: End of Your Operations ======
}
