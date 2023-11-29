/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.db.executer.PersistenceException;
import java.util.Optional;
import generated.kinoService.KinoService;
import src.db.executer.*;
import generated.kinoService.Seat;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoService.SeatRow;
import generated.kinoService.relationControl.seatRowSeatSupervisor;
public class SeatProxy implements ISeat{
   private Integer id;
   private Optional<Seat> theObject;
   public SeatProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public SeatProxy(Seat theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Seat getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Seat";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISeat)) return false;
      return ((ISeat)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Seat load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = KinoService.getInstance().getDmlExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Seat", this.id);
         SeatRow seatRow = seatRowSeatSupervisor.getInstance().getSeatRow(this).getTheObject();
         return Seat.instantiateRuntimeCopy(this, seatRow);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public SeatRow getSeatRow() throws PersistenceException{
      return this.getTheObject().getSeatRow();
   }
   public void setSeatRow(SeatRow newSeatRow)throws PersistenceException{
      this.getTheObject().setSeatRow(newSeatRow);
   }
}
