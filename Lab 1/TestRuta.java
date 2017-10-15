import junit.framework.TestCase;
import java.io.IOException;

public class TestRuta extends TestCase {

    private Validator v;

    public TestRuta()
    {
      try
      {
        v = new Validator("facil.txt");
      }
      catch (IOException e)
      {
        System.out.println("Problemas con la lectura del archivo");
        e.printStackTrace();
      }
    }

    public void testRuta1()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","0","1"});
      boolean expected = v.validate ("0", "1", results[0]);
      assertTrue ("fallo prueba 1", expected);
    }

    public void testRuta2()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","0","2"});
      boolean expected = v.validate ("0", "2", results[0]);
      assertTrue ("fallo prueba 2", expected);
    }

    public void testRuta3()
    { 
      String expected = "No hay ruta entre los dos puntos";
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","0","3"});
      String result = results[0];
      assertEquals ("fallo prueba 3", expected, result);
    }

    public void testRuta4()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","0","4"});
      boolean expected = v.validate ("0", "4", results[0]);
      assertTrue ("fallo prueba 4", expected);
    }

    public void testRuta5()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","0","5"});
      boolean expected = v.validate ("0", "5", results[0]);
      assertTrue ("fallo prueba 5", expected);
    }

    public void testRuta6()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","1","0"});
      boolean expected = v.validate ("1", "0", results[0]);
      assertTrue ("fallo prueba 6", expected);
    }

    public void testRuta7()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","1","2"});
      boolean expected = v.validate ("1", "2", results[0]);
      assertTrue ("fallo prueba 7", expected);
    }

    public void testRuta8()
    {
      String expected = "No hay ruta entre los dos puntos";
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","1","3"});
      String result = results[0];
      assertEquals ("fallo prueba 8", expected, result);
    }

    public void testRuta9()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","1","4"});
      boolean expected = v.validate ("1", "4", results[0]);
      assertTrue ("fallo prueba 9", expected);
    }

    public void testRuta10()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","1","5"});
      boolean expected = v.validate ("1", "5", results[0]);
      assertTrue ("fallo prueba 10", expected);
    }

    public void testRuta11()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","2","0"});
      boolean expected = v.validate ("2", "0", results[0]);
      assertTrue ("fallo prueba 11", expected);
    }

    public void testRuta12()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","2","1"});
      boolean expected = v.validate ("2", "1", results[0]);
      assertTrue ("fallo prueba 12", expected);
    }

    public void testRuta13()
    { 
      String expected = "No hay ruta entre los dos puntos";
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","2","3"});
      String result = results[0];
      assertEquals ("fallo prueba 13", expected, result);
    }

    public void testRuta14()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","2","4"});
      boolean expected = v.validate ("2", "4", results[0]);
      assertTrue ("fallo prueba 14", expected);
    }

    public void testRuta15()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","2","5"});
      boolean expected = v.validate ("2", "5", results[0]);
      assertTrue ("fallo prueba 15", expected);
    }

    public void testRuta16()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","3","0"});
      boolean expected = v.validate ("3", "0", results[0]);
      assertTrue ("fallo prueba 16", expected);
    }

    public void testRuta17()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","3","1"});
      boolean expected = v.validate ("3", "1", results[0]);
      assertTrue ("fallo prueba 17", expected);
    }

    public void testRuta18()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","3","2"});
      boolean expected = v.validate ("3", "2", results[0]);
      assertTrue ("fallo prueba 18", expected);
    }

    public void testRuta19()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","3","4"});
      boolean expected = v.validate ("3", "4", results[0]);
      assertTrue ("fallo prueba 19", expected);
    }

    public void testRuta20()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","3","5"});
      boolean expected = v.validate ("3", "5", results[0]);
      assertTrue ("fallo prueba 20", expected);
    }

    public void testRuta21()
    { 
      String expected = "No hay ruta entre los dos puntos";
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","4","0"});
      String result = results[0];
      assertEquals ("fallo prueba 21", expected, result);
    }

    public void testRuta22()
    { 
      String expected = "No hay ruta entre los dos puntos";
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","4","1"});
      String result = results[0];
      assertEquals ("fallo prueba 22", expected, result);
    }

    public void testRuta23()
    { 
      String expected = "No hay ruta entre los dos puntos";
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","4","2"});
      String result = results[0];
      assertEquals ("fallo prueba 23", expected, result);
    }

    public void testRuta24()
    { 
      String expected = "No hay ruta entre los dos puntos";
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","4","3"});
      String result = results[0];
      assertEquals ("fallo prueba 24", expected, result);
    }

    public void testRuta25()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","4","5"});
      boolean expected = v.validate ("4", "5", results[0]);
      assertTrue ("fallo prueba 25", expected);
    }

    public void testRuta26()
    { 
      String expected = "No hay ruta entre los dos puntos";
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","5","0"});
      String result = results[0];
      assertEquals ("fallo prueba 26", expected, result);
    }

    public void testRuta27()
    { 
      String expected = "No hay ruta entre los dos puntos";
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","5","1"});
      String result = results[0];
      assertEquals ("fallo prueba 27", expected, result);
    }

    public void testRuta28()
    { 
      String expected = "No hay ruta entre los dos puntos";
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","5","2"});
      String result = results[0];
      assertEquals ("fallo prueba 28", expected, result);
    }

    public void testRuta29()
    { 
      String expected = "No hay ruta entre los dos puntos";
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","5","3"});
      String result = results[0];
      assertEquals ("fallo prueba 29", expected, result);
    }

    public void testRuta30()
    { 
      String[] results = AbstractMainTests.executeMain("Ruta", new String[]{"facil.txt","5","4"});
      boolean expected = v.validate ("5", "4", results[0]);
      assertTrue ("fallo prueba 30", expected);
    }
}
