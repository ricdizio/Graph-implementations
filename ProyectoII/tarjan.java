import java.util.Stack;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;


public class Tarjan
{
    private int index;
    private Stack<Vertice> s;
    private List<List<Vertice>> componentesConexas;

    public Tarjan(Digrafo G) 
    {
        //Index
        this.index = 0;

        //Cojunto de conjuntos
        this.componentesConexas = new ArrayList<List<Vertice>>();

        //Pila
        s = new Stack<Vertice>();

        for (Vertice w : G.vertices())
        {
            if(w.index == -1)
            {
                strongConnect(w);
            }
        }
    }

    public void strongConnect(Vertice w)
    {
        w.index = this.index;
        w.lowLink = this.index;
        this.index = this.index + 1;
        s.push(w);
        w.onStack = true;

        //Cosideramos los sucesores
        for (Vertice x : w.getListaDeSucesores())
        {
            if(x.index == -1)
            {
                strongConnect(x);
                w.lowLink = Math.min(x.lowLink, w.lowLink);
            }
            else if(x.onStack)
            {
                w.lowLink = Math.min(w.lowLink, x.index);
            }
        }

        // Sacamos la componete conexa del stack
        Vertice c;
        //List<List<Vertice>> conjunto = new ArrayList<List<String>>();
        List<Vertice> conjunto = new ArrayList<Vertice>();
        if(w.lowLink == w.index)
        {
            do
            {
                c = s.pop();
                c.onStack = false;
                //Agregamos Vertice c a la componente conexa
                conjunto.add(c);
            }while(w != c);

            //Agregamos el conjunto de vertices que represta una componete conexa
            this.componentesConexas.add(conjunto);]
            //componetesConexas es una lista de lista de vertices
        }
    }

    public List<List<Vertice>> getComponentes()
    {
        return this.componentesConexas;
    }
}