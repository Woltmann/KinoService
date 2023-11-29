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
import generated.kinoService.relationControl.CiHa_SeRoSupervisor;
import generated.kinoService.relationControl.seRo_CaSupervisor;
import generated.kinoService.relationControl.seRo_SeatSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.kinoService.proxies.SeatRowProxy;
import observation.Observable;
import generated.kinoService.proxies.ISeatRow;
import generated.kinoService.relationControl.*;
import generated.kinoService.proxies.*;
import src.db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import generated.kinoService.proxies.ISeat;
import generated.kinoService.relationControl.seatRowSeatSupervisor;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class SeatRow extends Observable implements java.io.Serializable, ISeatRow
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Integer numberOfSeats;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private SeatRow(Integer id, Categorie categorie, Integer numberOfSeats, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      seRo_CaSupervisor.getInstance().set(this, categorie);
      this.numberOfSeats = numberOfSeats;
      if(objectOnly) return;
   }
   public static SeatRow createFresh(Categorie categorie, Integer numberOfSeats)throws PersistenceException{
      src.db.executer.PersistenceDMLExecuter dmlExecuter = KinoService.getInstance().getDmlExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("SeatRow", "id, typeKey, numberOfSeats", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoService", "SeatRow").toString() + ", " + numberOfSeats.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      SeatRow me = new SeatRow(id, categorie, numberOfSeats, false);
      KinoService.getInstance().addSeatRowProxy(new SeatRowProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoService.getInstance().getSeatRowCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      SeatRow toBeDeleted = KinoService.getInstance().getSeatRow(id);
      CiHa_SeRoSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      List<ISeat> ownersInseatRowSeat = seatRowSeatSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInseatRowSeat.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association seatRowSeat");
      seatRowSeatSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      seRo_CaSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KinoService.getInstance().getSeatRowCache().remove(id);
      KinoService.getInstance().getDmlExecuter().delete("SeatRow", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static SeatRow instantiateRuntimeCopy(SeatRowProxy proxy, Categorie categorie, Integer numberOfSeats)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new SeatRow(proxy.getId(), categorie, numberOfSeats, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public SeatRow getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISeatRow)) return false;
      return ((ISeatRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Categorie getCategorie() throws PersistenceException{
      return seRo_CaSupervisor.getInstance().getCategorie(this).getTheObject();
   }
   public void setCategorie(Categorie newCategorie)throws PersistenceException{
      seRo_CaSupervisor.getInstance().change(this, this.getCategorie(), newCategorie);
   }
   public Integer getNumberOfSeats() {
      return this.numberOfSeats;
   }
   public void setNumberOfSeats(Integer newNumberOfSeats) throws PersistenceException{
      this.numberOfSeats = newNumberOfSeats;
      try{KinoService.getInstance().getDmlExecuter().update("SeatRow", "numberOfSeats", newNumberOfSeats.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Set<Seat> getSeat() throws PersistenceException{
      Set<Seat> result = new HashSet<>();
      for (ISeat i : seatRowSeatSupervisor.getInstance().getSeat(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
