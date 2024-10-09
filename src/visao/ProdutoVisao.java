package visao;

import java.util.ArrayList;
import dominio.Produto;
import servico.ProdutoServico;

public class ProdutoVisao {
    
    private ProdutoServico srv;

    public ProdutoVisao(){
        this.srv = new ProdutoServico();
    }

    public void Exibir(){
        ArrayList<Produto> lista = this.srv.Navegar();
        System.out.println("===========================================================");
        for (Produto cp : lista) {
            this.Imprimir(cp);
        }
    }

    public void ExibirPorLinha(){
        ArrayList<Produto> lista = this.srv.Navegar();
        System.out.println("===========================================================");
        for (Produto cp : lista) {
            this.ImprimirPorLinha(cp);
        }
    }

    public void Imprimir(Produto cp){
        System.out.println("Classe de Produto:");
        System.out.println("Código: " + cp.getCodigo());
        System.out.println("Descrição: " + cp.getDescricao());
        System.out.println("Data de Inclusão: " + cp.getDataDeInclusao());
        System.out.println("Codigo SubClasse" + cp.getCodigoSubClasse());
        System.out.println("Valor" + cp.getValor());
        System.out.println("--------------------------------------------------------");
    }

    public void ImprimirPorLinha(Produto cp){
        String mensagem = "";
        mensagem += "Classe de Produto: ";
        mensagem += "Código: " + cp.getCodigo() + " | ";
        mensagem += "Descrição: " + cp.getDescricao() + " | ";
        mensagem += "Data de Inclusão: " + cp.getDataDeInclusao();
        System.out.println(mensagem);
    }

    public void ImprimirPorLinha(int chave){
        Produto cp = this.srv.Ler(chave);
        this.ImprimirPorLinha(cp);
    }


    public void Criar(Produto novo){
        this.srv.Adicionar(novo);
    }

    public void Editar(int chave, Produto alt){
        Produto cp = this.srv.Ler(chave);
        if (cp != null){
            cp.setDescricao(alt.getDescricao());
        }
        else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        Produto cp = this.srv.Ler(chave);
        if (cp != null){
            this.srv.Deletar(chave);
        }
        else{
            System.out.println("Item não localizado.");
        }

    }
}