/**
 *
 */

import java.util.*;

public class ClienteGrafo {
  public static void main(String [] args) {

  	Vertice x = new Vertice("1",2);	
  	String id = x.getId();
    Double peso = x.getPeso();
  	System.out.println("el id es "+id +"\n"+"el peso es "+ peso);
  }
}
