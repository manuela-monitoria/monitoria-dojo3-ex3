import java.util.*;
public class Livro {
    private String autor;
    private String editora;
    private String titulo;
    private Date dataPublicacao;
    private int codigo;
    private ArrayList<Aluguel> alugueis;

    public Livro(String autor, String editora, String titulo, Date dataPublicacao, int codigo) {
        this.autor = autor;
        this.editora = editora;
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.codigo = codigo;
    }

    public boolean isAlugado(){
        if(this.alugueis.size()==0) return false;
        return this.alugueis.get(alugueis.size()-1).estaAtivo();
    }
    
    public int getCodigo() {
    	return this.codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return codigo == livro.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
