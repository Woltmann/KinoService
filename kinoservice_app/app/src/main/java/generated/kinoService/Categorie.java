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
import observation.Observable;
import generated.kinoService.proxies.ICategorie;
import src.db.executer.PersistenceException;
import exceptions.ConstraintViolation;
import java.util.Optional;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public abstract class Categorie extends Observable implements java.io.Serializable, ICategorie
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Optional<Integer> basePrice;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public Categorie(Integer id, Optional<Integer> basePrice, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.basePrice = basePrice;
      if(objectOnly) return;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Categorie getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ICategorie)) return false;
      return ((ICategorie)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Optional<Integer> getBasePrice() {
      return this.basePrice;
   }
   public void setBasePrice(Integer newBasePrice) throws PersistenceException{
      this.basePrice = Optional.of(newBasePrice);
      try{KinoService.getInstance().getDmlExecuter().update("Categorie", "basePrice", newBasePrice.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
/**
 * Liefert den berechneten Preis für die Kategorie
 */
   public Integer calculatePrice(){
	   if (this.getBasePrice().isPresent()) {
	        return this.getBasePrice().get();
	    } else {
	        return 0;
	    } 
   }
//90 ===== GENERATED: End of Your Operations ======
}
