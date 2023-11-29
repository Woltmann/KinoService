/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.db.executer.PersistenceException;
import java.util.Optional;
import generated.kinoService.KinoService;
import src.db.executer.*;
import generated.kinoService.Client;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoService.Reservation;
import java.util.Set;
import generated.kinoService.Booking;
public class ClientProxy implements IClient{
   private Integer id;
   private Optional<Client> theObject;
   public ClientProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public ClientProxy(Client theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Client getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Client";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IClient)) return false;
      return ((IClient)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Client load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = KinoService.getInstance().getDmlExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Client", this.id);
         String name = rs.get().getString("name");
         String email = rs.get().getString("email");
         return Client.instantiateRuntimeCopy(this, name, email);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getName() {
      return this.getTheObject().getName();
   }
   public void setName(String newName) throws PersistenceException{
      this.getTheObject().setName(newName);
   }
   public String getEmail() {
      return this.getTheObject().getEmail();
   }
   public void setEmail(String newEmail) throws PersistenceException{
      this.getTheObject().setEmail(newEmail);
   }
   public Set<Reservation> getReservation() throws PersistenceException{
      return this.getTheObject().getReservation();
   }
   public Set<Booking> getBooking() throws PersistenceException{
      return this.getTheObject().getBooking();
   }
}
