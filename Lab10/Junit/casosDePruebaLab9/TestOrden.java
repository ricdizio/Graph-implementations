import junit.framework.TestCase;
import java.io.IOException;

public class TestOrden extends TestCase {

    public void testOrden1()
    { 
      Verificador.Grafo g  = new Verificador.Grafo("dependencias.txt");
      String[] results = AbstractMainTests.executeMain("Orden", new String[]{"dependencias.txt"});
      String result = "";
      for (int i = 0; i < results.length; i++)
        result += results[i];
      boolean expected = g.validate (result);
      assertTrue ("fallo prueba 1", expected);
    }

    public void testOrden2()
    { 
      Verificador.Grafo g  = new Verificador.Grafo("dependencias2.txt");
      String[] results = AbstractMainTests.executeMain("Orden", new String[]{"dependencias2.txt"});
      String result = "";
      for (int i = 0; i < results.length; i++)
        result += results[i];
      boolean expected = g.validate (result);
      assertTrue ("fallo prueba 2", expected);
    }

    public void testOrden3()
    { 
      Verificador.Grafo g  = new Verificador.Grafo("dependencias3.txt");
      String[] results = AbstractMainTests.executeMain("Orden", new String[]{"dependencias3.txt"});
      String result = "";
      for (int i = 0; i < results.length; i++)
        result += results[i];
      boolean expected = g.validate (result);
      assertTrue ("fallo prueba 3", expected);
    }

    public void testOrden4()
    { 
      Verificador.Grafo g  = new Verificador.Grafo("dependencias4.txt");
      String[] results = AbstractMainTests.executeMain("Orden", new String[]{"dependencias4.txt"});
      String result = "";
      for (int i = 0; i < results.length; i++)
        result += results[i];
      boolean expected = g.validate (result);
      assertTrue ("fallo prueba 4", expected);
    }

    public void testOrden5()
    { 
      Verificador.Grafo g  = new Verificador.Grafo("dependencias5.txt");
      String[] results = AbstractMainTests.executeMain("Orden", new String[]{"dependencias5.txt"});
      String result = "";
      for (int i = 0; i < results.length; i++)
        result += results[i];
      boolean expected = g.validate (result);
      assertTrue ("fallo prueba 5", expected);
    }

    public void testOrden6()
    { 
      Verificador.Grafo g  = new Verificador.Grafo("dependencias6.txt");
      String[] results = AbstractMainTests.executeMain("Orden", new String[]{"dependencias6.txt"});
      String result = "";
      for (int i = 0; i < results.length; i++)
        result += results[i];
      boolean expected = g.validate (result);
      assertTrue ("fallo prueba 6", expected);
    }
}
