import java.util.*;

public class Biblioteca {
    private ArrayList<Cliente> clientes;
    private ArrayList<Livro> livros;
    private ArrayList<Aluguel> alugueis;

    public Biblioteca(){
        this.livros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.alugueis = new ArrayList<>();
    }

    public boolean adicionaCliente(Cliente cliente){
        if(clientes.contains(cliente))
            return false;
        clientes.add(cliente);
        return true;
    }

    public boolean removeCliente(String cpf){
        //todo: trocar para receber o cpf e achar o cliente na lista pelo cpf
        //todo: fazer função de busca do cliente (pelo cpf)
        for(Cliente a: clientes){
            if(a.getCpf().equals(cpf) && !a.temAlugueisAtivos()){
                clientes.remove(a);
                return true;
            }
        }

        return false;
    }
    
    public Livro retornaLivroCodigo(int codigo) {
    	for(Livro livro: livros) {
    		if(livro.getCodigo() == codigo) {
    			return livro;
    		}
    	}
    	
    	return null;
    }
    
    public Cliente retornaClienteCpf(String cpf) {
    	for(Cliente cliente: clientes) {
    		if(cliente.getCpf() == cpf) {
    			return cliente;
    		}
    	}
    	
    	return null;
    }

    public boolean adicionaLivro(Livro livro){
        if(livros.contains(livro))
            return false;
        livros.add(livro);
        return true;
    }

    public boolean removeLivro(Livro livro){
        if(livros.contains(livro) && !livro.isAlugado()){
            livros.remove(livro);
            return true;
        }
        return false;
    }

    public boolean fazAluguel(Livro livro, Cliente cliente){
        //verificar se o livro existe
        //verificar se o livro não está alugado
        //verificar se o cliente pode alugar mais um
        //verificar se o cliente não pegou eles (3 ultimos)
        if (!livro.isAlugado() &&
                cliente.temLimiteParaAlugar() &&
                !cliente.estaTresUltimosAlugados(livro)){
            Date hoje = new Date();
            Date dataHojeSemHora = new Date(hoje.getDate(),hoje.getMonth(),hoje.getYear() );

            Aluguel aluguel = new Aluguel(livro, cliente, hoje);
            return true;

//            cliente.adicionarAluguelNoHistoricoTresUltimos(aluguel);
            //todo: adicionar no historico de alugueis do Livro
            //todo: adicionar no historico da biblioteca tambem




        }

        return false; //todo: remover quando completar o codigo

    }

}
