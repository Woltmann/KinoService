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
import generated.kinoService.relationControl.seRo_SeatSupervisor;
import generated.kinoService.relationControl.rese_SeatSupervisor;
import generated.kinoService.relationControl.book_SeatSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.kinoService.proxies.SeatProxy;
import observation.Observable;
import generated.kinoService.proxies.ISeat;
import src.db.executer.PersistenceException;
import generated.kinoService.relationControl.seatRowSeatSupervisor;
import generated.kinoService.relationControl.*;
import generated.kinoService.proxies.*;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Seat extends Observable implements java.io.Serializable, ISeat
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Seat(Integer id, SeatRow seatRow, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      seatRowSeatSupervisor.getInstance().set(this, seatRow);
      if(objectOnly) return;
   }
   public static Seat createFresh(SeatRow seatRow)throws PersistenceException{
      src.db.executer.PersistenceDMLExecuter dmlExecuter = KinoService.getInstance().getDmlExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Seat", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoService", "Seat").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Seat me = new Seat(id, seatRow, false);
      KinoService.getInstance().addSeatProxy(new SeatProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoService.getInstance().getSeatCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Seat toBeDeleted = KinoService.getInstance().getSeat(id);
      rese_SeatSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      book_SeatSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      seatRowSeatSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KinoService.getInstance().getSeatCache().remove(id);
      KinoService.getInstance().getDmlExecuter().delete("Seat", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Seat instantiateRuntimeCopy(SeatProxy proxy, SeatRow seatRow)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Seat(proxy.getId(), seatRow, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Seat getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISeat)) return false;
      return ((ISeat)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public SeatRow getSeatRow() throws PersistenceException{
      return seatRowSeatSupervisor.getInstance().getSeatRow(this).getTheObject();
   }
   public void setSeatRow(SeatRow newSeatRow)throws PersistenceException{
      seatRowSeatSupervisor.getInstance().change(this, this.getSeatRow(), newSeatRow);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
