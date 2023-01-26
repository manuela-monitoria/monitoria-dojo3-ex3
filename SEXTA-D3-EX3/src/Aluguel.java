import java.util.*;

public class Aluguel {
    private Livro livro;
    private Cliente cliente;
    private Date dataEmprestimo;
    private Date dataRetorno;
    private ArrayList<Livro> livros;


    public Aluguel(Livro livro, Cliente cliente, Date dataEmprestimo) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataRetorno = null;
        cliente.adicionarAluguelAtivo(this);
    }
    
    public Aluguel(ArrayList<Livro> livros, Cliente cliente, Date dataEmprestimo) {
        this.livros = livros;
        this.cliente = cliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataRetorno = null;
        cliente.adicionarAluguelAtivo(this);
    }

    public boolean estaAtivo(){
        return dataRetorno == null;
    }

    public Livro getLivro() {
        return livro;
    }
}
