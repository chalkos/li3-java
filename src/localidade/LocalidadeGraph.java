
package localidade;


public class LocalidadeGraph {
    public static final int DESCONHECIDO = -1;
    public static final int NAORLA = 0;
    public static final int VISITADO = 1;
    private String nome;
    private String nomeAnterior;
    private int distanciaLocalidades;
    private int estado;
    
    public LocalidadeGraph()
    {
        this.nome="";
        this.nomeAnterior="";
        this.distanciaLocalidades=0;
        this.estado=DESCONHECIDO;  
    }
    
    public LocalidadeGraph(String nome)
    {
        this.nome=nome;
        this.nomeAnterior="";
        this.distanciaLocalidades=0;
        this.estado=NAORLA;
    }
    
    public LocalidadeGraph(String nome, String anterior, int distanciaLocalidades, int estado)
    {
        this.nome=nome;
        this.nomeAnterior=anterior;
        this.distanciaLocalidades=distanciaLocalidades;
        this.estado=estado;
    }
    
    public LocalidadeGraph(LocalidadeGraph localidade)
    {
        this.nome=localidade.getNome();
        this.nomeAnterior=localidade.getAnterior();
        this.distanciaLocalidades=localidade.getDistancia();
        this.estado=localidade.getEstado();
    }

    public String getNome()
    {
        return this.nome;
    }
            
    public String getAnterior()
    {
        return this.nomeAnterior;
    }
    
    public int getDistancia()
    {
        return this.distanciaLocalidades;
    }
    
    public int getEstado()
    {
        return this.estado;
    }
    
    public void setAnterior(String anterior)
    {
        this.nomeAnterior=anterior;
    }
            
    
    public void setEstado(int estado)
    {
        this.estado=estado;
    }
          
    public void setDistancia(int distancia)
    {
        this.distanciaLocalidades =distancia;
    }
    
    @Override
    public LocalidadeGraph clone(){
        return new LocalidadeGraph(this);
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder(50);
        str.append(this.getNome()).append("\n");
        return str.toString();
    }
    
    
}

