package pagination;

import java.util.ArrayList;
import java.util.Random;
/**
 * @see https://www.jc-mouse.net/
 * @author mouse
 */
public class Dummy {
    
   
    static String getFullName(){
        Random randomGenerator  = new Random();   
        
        ArrayList<String> name = new ArrayList();        
        name.add("Juan");name.add("Carmen");
        name.add("Maria");name.add("Camila");
        name.add("Pablo");name.add("Cornelio");
        name.add("Anibal");name.add("Ruben");
        name.add("Julio");name.add("Manfred");
        name.add("Ana");name.add("Luis");
        name.add("Luz");name.add("Lucas");
        name.add("Gretta");name.add("Lauren");
        
        ArrayList<String> lastName = new ArrayList();        
        lastName.add("Perez");lastName.add("Bayle");
        lastName.add("Panama");lastName.add("Simpsons");
        lastName.add("Choque");lastName.add("Bush");
        lastName.add("Tamayo");lastName.add("Obama");
        lastName.add("da Silva");lastName.add("Trump");
        lastName.add("Souza");lastName.add("Toledo");
        
        String fullName = name.get(randomGenerator.nextInt(name.size())) +  " " + 
                          lastName.get(randomGenerator.nextInt(lastName.size())) + " " + 
                          lastName.get(randomGenerator.nextInt(lastName.size()));        
        return fullName;
    }
    
    
    static String randomHexColor(){
        Random randomGenerator = new Random();        
        int r =  randomGenerator.nextInt(155) + 100;
        int g =  randomGenerator.nextInt(155) + 100;
        int b =  randomGenerator.nextInt(155) + 100;
        return String.format("#%02x%02x%02x", r, g, b);         
    }
    
}
