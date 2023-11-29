/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.db.executer.PersistenceException;
import java.util.Optional;
import generated.kinoService.KinoService;
import src.db.executer.*;
import generated.kinoService.Cinemahall;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoService.SeatRow;
import java.util.Set;
public class CinemahallProxy implements ICinemahall{
   private Integer id;
   private Optional<Cinemahall> theObject;
   public CinemahallProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public CinemahallProxy(Cinemahall theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Cinemahall getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Cinemahall";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ICinemahall)) return false;
      return ((ICinemahall)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Cinemahall load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = KinoService.getInstance().getDmlExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Cinemahall", this.id);
         String hallname = rs.get().getString("hallname");
         Boolean isFree = rs.get().getBoolean("isFree");
         return Cinemahall.instantiateRuntimeCopy(this, hallname, isFree);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Set<SeatRow> getSeatRow() throws PersistenceException{
      return this.getTheObject().getSeatRow();
   }
   public void addToSeatRow(SeatRow arg) throws PersistenceException{
      this.getTheObject().addToSeatRow(arg);
   }
   public boolean removeFromSeatRow(SeatRow arg) throws PersistenceException{
      return this.getTheObject().removeFromSeatRow(arg);
   }
   public String getHallname() {
      return this.getTheObject().getHallname();
   }
   public void setHallname(String newHallname) throws PersistenceException{
      this.getTheObject().setHallname(newHallname);
   }
   public Boolean getIsFree() {
      return this.getTheObject().getIsFree();
   }
   public void setIsFree(Boolean newIsFree) throws PersistenceException{
      this.getTheObject().setIsFree(newIsFree);
   }
}
