/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.db.executer.PersistenceException;
import generated.kinoService.Categorie;
import java.util.Optional;
public abstract class CategorieProxy implements ICategorie{
   public abstract Categorie getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof ICategorie)) return false;
      return ((ICategorie)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Optional<Integer> getBasePrice() {
      return this.getTheObject().getBasePrice();
   }
   public void setBasePrice(Integer newBasePrice) throws PersistenceException{
      this.getTheObject().setBasePrice(newBasePrice);
   }
}
