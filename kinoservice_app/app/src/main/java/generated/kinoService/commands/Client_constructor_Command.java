/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class Client_constructor_Command extends ServiceCommand<Client>{
   private static final long serialVersionUID = 250217225L;
   private String  name;
   private String  email;
   public Client_constructor_Command(String  name, String  email){
      super();
      this.name = name;
      this.email = email;
   }
   public void execute(){
      try{this.result = Client.createFresh(name, email);
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
   public String  name(){return name;}
   public String  email(){return email;}
}
