/**
 * 
 */

public class Vertice
{
  private String id;
  private double peso;
  private List<Vertice> getListaDeAdyacencias;
  private List<Vertice> getListaDeSucesores;
  private List<Vertice> getListaDeAdyacenciasPredecesores;
  
  public Vertice(String id, double peso) {
    this.id = id;
    this.peso = peso;
  }

  public double getPeso() {
    return this.peso;
  }

  public String getId() {
    return this.id;
  }

  public String toString() { 
    return "El Vertice tiene el id: " + this.id + " y peso: " + this.peso; 
  }
}