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

  //private List<Vertice> getListaDeAdyacencias;
  //private List<Vertice> getListaDeSucesores;
  //private List<Vertice> getListaDePredecesores;
  //private List<Lado> getListaDeIncidencias;

  
  public Vertice(String id, double peso) {
    this.id = id;
    this.peso = peso;
    this.adyacencias = new LinkedList<Vertice>();
    this.sucesores = new LinkedList<Vertice>();
    this.predecesores = new LinkedList<Vertice>();
    this.incidencias = new LinkedList<Lado>();

    List<Vertice> adyacencias = new LinkedList<Vertice>();
    List<Vertice> sucesores = new LinkedList<Vertice>();
    List<Vertice> predecesores = new LinkedList<Vertice>();
    List<Lado> incidencias = new LinkedList<Lado>();
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

  public List<Vertice> getListaDeAdyacencias(){
    return this.adyacencias;
  }

  public List<Lado> getListaDeIncidencias(){
    return this.incidencias;
  }

  public List<Vertice> getListaDePredecesores(){
    return this.predecesores;
  }

  public List<Vertice> getListaDeSucesores(){
    return this.sucesores;
  }
}