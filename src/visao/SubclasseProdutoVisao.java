package visao;

import java.util.ArrayList;
import dominio.SubclasseProduto;
import servico.SubclasseProdutoServico;

public class SubclasseProdutoVisao {
    
    private SubclasseProdutoServico srv;

    public SubclasseProdutoVisao(){
        this.srv = new SubclasseProdutoServico();
    }

    public void Exibir(){
        ArrayList<SubclasseProduto> lista = this.srv.Navegar();
        System.out.println("===========================================================");
        for (SubclasseProduto cp : lista) {
            this.Imprimir(cp);
        }
    }

    public void ExibirPorLinha(){
        ArrayList<SubclasseProduto> lista = this.srv.Navegar();
        System.out.println("===========================================================");
        for (SubclasseProduto cp : lista) {
            this.ImprimirPorLinha(cp);
        }
    }

    public void Imprimir(SubclasseProduto cp){
        System.out.println("Classe de Produto:");
        System.out.println("Código: " + cp.getCodigo());
        System.out.println("Descrição: " + cp.getDescricao());
        System.out.println("Data de Inclusão: " + cp.getDataDeInclusao());
        System.out.println("Codigo Classe" + cp.getCodigoClasse());
        System.out.println("--------------------------------------------------------");
    }

    public void ImprimirPorLinha(SubclasseProduto cp){
        String mensagem = "";
        mensagem += "Classe de Produto: ";
        mensagem += "Código: " + cp.getCodigo() + " | ";
        mensagem += "Descrição: " + cp.getDescricao() + " | ";
        mensagem += "Data de Inclusão: " + cp.getDataDeInclusao();
        mensagem += "Codigo Classe" + cp.getCodigoClasse();
        System.out.println(mensagem);
    }

    public void ImprimirPorLinha(int chave){
        SubclasseProduto cp = this.srv.Ler(chave);
        this.ImprimirPorLinha(cp);
    }


    public void Criar(SubclasseProduto novo){
        this.srv.Adicionar(novo);
    }

    public void Editar(int chave, SubclasseProduto alt){
        SubclasseProduto cp = this.srv.Ler(chave);
        if (cp != null){
            cp.setDescricao(alt.getDescricao());
        }
        else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        SubclasseProduto cp = this.srv.Ler(chave);
        if (cp != null){
            this.srv.Deletar(chave);
        }
        else{
            System.out.println("Item não localizado.");
        }

    }
}