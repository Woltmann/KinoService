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
import generated.kinoService.proxies.IParquet;
import src.db.executer.PersistenceException;
import java.util.Optional;
import java.sql.ResultSet;
import src.idManagement.IDManagerTransient;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Parquet extends Categorie implements java.io.Serializable, IParquet
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<Parquet> theInstance = Optional.empty();
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Parquet(Integer id, Optional<Integer> basePrice, boolean objectOnly)
   {
      super(id, basePrice, objectOnly);
      if(objectOnly) return;
   }
   private static Parquet instantiateRuntimeCopy(Integer id, Optional<Integer> basePrice){
      return new Parquet(id, basePrice, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Parquet getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Parquet load() throws PersistenceException {
      try{
         Integer typeKey = PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoService", "Parquet");
         Optional<ResultSet> rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter("KinoService").selectEntriesOfTable("Categorie", typeKey);
         if(rs.isPresent()) rs.get().next();
         Integer id = rs.isPresent() ? rs.get().getInt("id") : IDManagerTransient.getTheInstance().getNextId();
         Optional<Integer> basePrice = Optional.empty();
         if(rs.isPresent()) basePrice = (rs.get().getObject("basePrice") == null ? Optional.empty() : Optional.of(rs.get().getInt("basePrice")));
         return Parquet.instantiateRuntimeCopy(id, basePrice);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Parquet getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
   /**
    * Liefert den berechneten Preis für die Kategorie
    */
   @Override
      public Integer calculatePrice(){
	   if (this.getBasePrice().isPresent()) {
	        return this.getBasePrice().get();
	    } else {
	        return 0;
	    }    
      }
//90 ===== GENERATED: End of Your Operations ======
}
