/**
 * 
 */

import java.util.*;

public class Vertice
{
  private String id;
  private double peso;
  public List<Vertice> adyacencias;
  public List<Vertice> sucesores;
  public List<Vertice> predecesores;
  public List<Lado> incidencias;
  
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

  public List getListaDeAdyacencias(){
    return adyacencias;
  }

  public List getListaDeIncidencias(){
    return incidencias;
  }

  public List getListaDePredecesores(){
    return predecesores;
  }

  public List getListaDeSucesores(){
    return sucesores;
  }
}