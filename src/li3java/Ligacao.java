package li3java;

/**
 * Ligações entre localidades
 */
public class Ligacao {
    String nome;
    double custo;
    double distancia;
    
    public Ligacao(){
        nome = "";
        custo = 0;
        distancia = 0;
    }

    public Ligacao(String nome, double distancia, double custo) {
        this.nome = nome;
        this.custo = custo;
        this.distancia = distancia;
    }

    public Ligacao(String nome) {
        this.nome = nome;
        this.custo = 0;
        this.distancia = 0;
    }
    
    public Ligacao(Ligacao nova){
        this.nome = nova.getNome();
        this.custo = nova.getCusto();
        this.distancia = nova.getDistancia();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public double getCusto(){
        return this.custo;
    }
    
    public double getDistancia(){
        return this.distancia;
    }
    
    public boolean equals(Ligacao nova){
        if(this.getNome().compareTo(nova.getNome()) == 0)
            return true;
        return false;
    }
    
    @Override
    public Ligacao clone(){
        return new Ligacao(this);
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("{ ")
                .append(this.getNome())
                .append("(nome), ")
                .append(this.getDistancia())
                .append("(dist), ")
                .append(this.getCusto())
                .append("(custo) }");
        return str.toString();
    }
}
