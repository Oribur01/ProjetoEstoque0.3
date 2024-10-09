package fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.Produto;


public class ProdutoFakeDB extends BaseFakeDB<Produto> {

    public Object getTabela;
    
    @Override
    public void preencherDados() {
        if (this.tabela == null){
            this.tabela = new ArrayList<>();
        }
        this.tabela.add(new Produto(1,"Carnes", LocalDate.now(), 1, 2.00));
    }

    public ProdutoFakeDB(){
        super();
    }
  
       
}

