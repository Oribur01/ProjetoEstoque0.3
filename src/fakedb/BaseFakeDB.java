package fakedb;

import java.util.ArrayList;

public abstract class BaseFakeDB<TDominio> {

    protected ArrayList<TDominio> tabela;

    public BaseFakeDB(){
        this.tabela = new ArrayList<>();
        this.preencherDados();
    }
    
    public ArrayList<TDominio>getTabela(){
        return this.tabela;
    }

    public abstract void preencherDados();

}
