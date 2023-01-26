import java.sql.Date;
import java.util.Objects;
import java.util.Scanner;

public class Menu {

    private Biblioteca biblioteca;


    public Menu(){
        biblioteca = new Biblioteca();

    }

    public void apresentaMenu(){
        int opcoes = 0;

        do {
            this.escreveOpcoes();
             opcoes = leInt();
            switch (opcoes){
                case 1:

                    //usuario digitar as informaÃ§Ãµes
                    Cliente cliente = criaCliente();
                    //chamar biblioteca.adcionaCliente
                    boolean cadastrado = biblioteca.adicionaCliente(cliente);
                    if(cadastrado == true) {
                    	System.out.println("Cliente cadastrado com sucesso!");
                    } else {
                    	System.out.println("Erro no cadastro, tente novamente.");
                    }
                    break;
                case 2:

                    //chama a funÃ§Ã£o
                	String cpfCliente = removeCliente();
                    boolean removido = biblioteca.removeCliente(cpfCliente);
                    if(removido == true) {
                    	System.out.println("Cliente cadastrado com sucesso!");
                    } else {
                    	System.out.println("Erro na remoção, tente novamente.");
                    }
                    break;
                case 3:
                	Livro livro = cadastrarLivro();
                	boolean livroCadastrado = biblioteca.adicionaLivro(livro);
                	if(livroCadastrado == true) {
                		System.out.println("Livro cadastrado com sucesso!");
                	} else {
                		System.out.println("Erro no cadastro, tente novamente.");
                	}
                	break;
                case 5:
                	cadastrarAluguel();
                	break;
                case 0:
                    break;
            }
        }while (opcoes != 0);

    }
    /*
    public static void menu(Biblioteca biblioteca){
        System.out.println("\n---- menu ---- \n(1) Cadastrar cliente\n(2) Remover cliente");

        int opcao = leInt();
        if (opcao == 1){
            //usuario digitar as informaÃ§Ãµes
            Cliente cliente = criaCliente();
            //chamar biblioteca.adcionaCliente
            biblioteca.adiconaCliente(cliente);
        }
        if (opcao == 2){
            //usuario digitar as informaÃ§Ãµes (talvez trocar para digitar sÃ³ o cpf, sem precisar instanciar o cliente)
            Cliente cliente = criaCliente();
            //chama a funÃ§Ã£o
            System.out.println("Insira CPF DO USUÃ�RIO A SER REMOVIDO");
            String cpf = leString();
            biblioteca.removeCliente(cpf);
        }
    }
*/
    public Cliente criaCliente(){
        System.out.println("Nome: ");
        String nome = leString();
        System.out.println("CPF: ");
        String cpf = leString();
        Cliente c = new Cliente(nome, cpf);
        return c;
    }
    public String removeCliente() {
        System.out.println("Insira CPF DO USUÁRIO A SER REMOVIDO");
        String cpf = leString();
        return cpf;
    }
    
    public Livro cadastrarLivro() {
        System.out.println("Titulo: ");
        String titulo = leString();
        System.out.println("Autor: ");
        String autor = leString();
        System.out.println("Código: ");
        int codigo = leInt();
        System.out.println("Editora: ");
        String editora = leString();
        System.out.println("Data de publicação: ");
        String dataPublicacao = leString();
        Date dataPublicacaoDate = Date.valueOf(dataPublicacao);
        Livro livro = new Livro(titulo, autor, editora, dataPublicacaoDate, codigo);
        return livro;
    }
    
    public void cadastrarAluguel() {
        System.out.println("CPF do cliente: ");
        String cpf = leString();
        Cliente cliente = biblioteca.retornaClienteCpf(cpf);
        if(Objects.isNull(cliente)) {
        	System.out.println("Cliente não existe, tente de novo.");
        	return;
        }
        System.out.println("Quantidade de livros: ");
        int quantidade = leInt();
        for(int i = 0; i < quantidade && quantidade < 3; i++) {
            System.out.println("Código do livro: ");
            int codigo = leInt();
            Livro livro = biblioteca.retornaLivroCodigo(codigo);
            if(Objects.isNull(livro)) {
            	System.out.println("Livro não existe, tente de novo.");
            	return;
            }
            biblioteca.fazAluguel(livro, cliente);        
        }
    }
    
    public String leString(){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        return s;
    }
    public int leInt(){
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        return i;
    }

    public void escreveOpcoes(){
        System.out.println("\n---- menu ---- \n(1) Cadastrar cliente\n(2) Remover cliente");
        System.out.println("(3) Cadastrar livro");
        System.out.println("(4) Remover livro");
        System.out.println("(5) Alugar livro");
        System.out.println("(6) Devolver livro");
        System.out.println("(7) Relatório de alugueis");
        System.out.println("(0) Encerrar");
    }

    }

