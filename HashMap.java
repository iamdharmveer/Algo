import java.util.*;
public class HashMap {

   public static void main(String args[]) { 
      // Create a HashMap
      
      HashMap hm = new HashMap(); 
      // Put elements to the map
      
      hm.put("Veer", new Double(3434.34));
      hm.put("Rus", new Double(123.22));
      hm.put("Akash", new Double(1378.00));
      hm.put("Dharm", new Double(99.22));
      hm.put("Gajju", new Double(-19.08));
      
      // Get a set of the entries
      Set set = hm.entrySet();
      
      // Get an iterator
      Iterator i = set.iterator();
      
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
      
      // Deposit 1000 into Veer's account
      double balance = ((Double)hm.get("Veer")).doubleValue();
      hm.put("Veer", new Double(balance + 1000));
      System.out.println("Zara's new balance: " + hm.get("Veer"));
   }
}
