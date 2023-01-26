import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    private String nome, cpf;
    private ArrayList<Aluguel> alugueis;
//    private ArrayList<Aluguel> historico3Ultimos;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.alugueis = new ArrayList<>();
//        this.historico3Ultimos = new ArrayList<>();
    }

    public boolean estaTresUltimosAlugados(Livro livro){
        for (int i = alugueis.size() - 1; i >= 0 && i >= alugueis.size() - 4; i --){
            if (alugueis.get(i).getLivro().equals(livro))
                return true;
        }
        return false;
    }

    private int qtdAlugueisAtivos(){
        int qtd = 0;
        for (Aluguel a : alugueis)
            if (a.estaAtivo())
                qtd ++;
        return qtd;
    }

    public boolean temAlugueisAtivos() {
        return qtdAlugueisAtivos() != 0;
    }

    public boolean temLimiteParaAlugar() {
        return qtdAlugueisAtivos() < 2;
    }

//    public boolean estaAtivo (){
//        for (Aluguel a : alugueis)
//            if (a.estaAtivo())
//                return true;
//        return false;
//    }

    public boolean adicionarAluguelAtivo(Aluguel aluguel){
        return this.alugueis.add(aluguel);
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
