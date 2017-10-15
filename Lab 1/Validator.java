import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Validator
{
  int[][] adyMatrix;

  public Validator(String fileName) throws IOException
  {
      String s;
      String[] tok;
      BufferedReader in = new BufferedReader(new FileReader(fileName));
      s = in.readLine();
      int nVertex = (new Integer(s)).intValue();
      adyMatrix = new int[nVertex][nVertex];

      s = in.readLine();
      int nEdges = (new Integer(s)).intValue();
      int k = 0;
      while ( (s = in.readLine()) != null)
      {
        tok = s.split(" ");
        int first = (new Integer(tok[0])).intValue();
        adyMatrix[first][(new Integer(tok[1])).intValue()] = 1;
        k++;
      }

      in.close();
  }

  public boolean validate(String iniStr, String finStr, String str)
  {
    if (str.equals("No hay ruta entre los dos puntos"))
      throw new UnsupportedOperationException("El programa Validator no tiene implementado " + 
                                              "una verificacion cuando no existe ruta entre "+ 
                                              "dos puntos");

    String[] tok = str.split(" ");
    int nVertex = adyMatrix.length;

    boolean correct = (iniStr.equals(tok[0]) && finStr.equals(tok[tok.length-1]));
    int i = 1;
    while (i < tok.length && correct)
    {
      try
      {
        int iniVertex = (new Integer(tok[i-1])).intValue();
        int finVertex = (new Integer(tok[i])).intValue();
        if (adyMatrix[iniVertex][finVertex] == 0)
          correct = false;
      }
      catch (ArrayIndexOutOfBoundsException e)
      {
          correct = false;
      }
      catch (NumberFormatException e)
      {
          correct = false;
      }
      i++;
    }

    return correct;
  }

  public static void main (String[] args)
  {
    try
    {
      // Verificar si el numero de args en correcto
      Validator v = new Validator (args[0]);

      String arg;
      if (args.length == 3)
        arg = "";
      else
        arg = args[args.length-1];

      for (int i = args.length-2; i > 2; i--)
        arg = args[i] + " " + arg;

      if (v.validate(args[1], args[2], arg))
        System.out.println("Resultado correcto");
      else
        System.out.println("Resultado incorrecto");
    }
    catch (IOException e)
    {
      System.out.println("Problemas con la lectura del archivo");
      e.printStackTrace();
    }
    catch (UnsupportedOperationException e)
    {
      e.printStackTrace();
    }
  }
}
