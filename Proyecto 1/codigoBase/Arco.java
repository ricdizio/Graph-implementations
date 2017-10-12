/**
 *
 */

public class Arco extends Lado
{
  private Vertice extremoInicial;
  private Vertice extremoFinal;
  
  public Arco(String id, double peso, Vertice extremoInicial, Vertice extremoFinal) {
    super(id,peso);
    this.extremoInicial = extremoInicial;
    this.extremoFinal = extremoFinal;
  }

  public Vertice getExtremoInicial() {
    return this.u;
  }

  public Vertice getExtremoFinall() {
    return this.v;
  }
  // Hola Mundo
  public String toString() {
    return "El arco tiene como extremo incial: " + this.extremoInicial + " y extremoFinal: " + this.extremoFinal; 
  }
}
