/**
 *
 */

public class Arista extends Lado
{
  private Vertice u;
  private Vertice v;
  
  public Arista(String id, double peso, Vertice u, Vertice v) {
    super(id,peso)
    this.u = u;
    this.v = v;
  }

  public Vertice getExtremo1() {
    return this.u;
  }

  public Vertice getExtremo2() {
    return this.v;
  }

  public String toString() {
    return "La arista tiene como vertice:  " + this.u + " y " + this.v;
  }
}