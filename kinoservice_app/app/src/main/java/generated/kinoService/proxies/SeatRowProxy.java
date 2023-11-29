/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.db.executer.PersistenceException;
import java.util.Optional;
import generated.kinoService.KinoService;
import src.db.executer.*;
import generated.kinoService.SeatRow;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoService.Categorie;
import generated.kinoService.relationControl.seRo_CaSupervisor;
import generated.kinoService.Seat;
import java.util.Set;
public class SeatRowProxy implements ISeatRow{
   private Integer id;
   private Optional<SeatRow> theObject;
   public SeatRowProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public SeatRowProxy(SeatRow theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public SeatRow getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "SeatRow";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISeatRow)) return false;
      return ((ISeatRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private SeatRow load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = KinoService.getInstance().getDmlExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("SeatRow", this.id);
         Categorie categorie = seRo_CaSupervisor.getInstance().getCategorie(this).getTheObject();
         Integer numberOfSeats = rs.get().getInt("numberOfSeats");
         return SeatRow.instantiateRuntimeCopy(this, categorie, numberOfSeats);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Categorie getCategorie() throws PersistenceException{
      return this.getTheObject().getCategorie();
   }
   public void setCategorie(Categorie newCategorie)throws PersistenceException{
      this.getTheObject().setCategorie(newCategorie);
   }
   public Integer getNumberOfSeats() {
      return this.getTheObject().getNumberOfSeats();
   }
   public void setNumberOfSeats(Integer newNumberOfSeats) throws PersistenceException{
      this.getTheObject().setNumberOfSeats(newNumberOfSeats);
   }
   public Set<Seat> getSeat() throws PersistenceException{
      return this.getTheObject().getSeat();
   }
}
