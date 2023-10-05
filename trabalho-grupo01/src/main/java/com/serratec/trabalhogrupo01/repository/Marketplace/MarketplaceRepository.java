package com.serratec.trabalhogrupo01.repository.Marketplace;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.serratec.trabalhogrupo01.model.Marketplace.MarketplaceModel;

@Repository
public class MarketplaceRepository {
    
    private List<MarketplaceModel> listaProdutos = new ArrayList<>();
    private long ultimoId = 0; 

    public List<MarketplaceModel> obterTodos(){
        return listaProdutos;
    }

    public MarketplaceModel obter(Long id){
        
        MarketplaceModel produtoEcontrado = null;

        for (MarketplaceModel produto : listaProdutos){
            if(produto.getIdProduto() == id){
                produtoEcontrado = produto ;
            } 
        }

        return produtoEcontrado;
    }

    public MarketplaceModel adicionar (MarketplaceModel produto){

        ultimoId++;
        produto.setIdProduto(ultimoId);
        listaProdutos.add(produto);

        return produto; 
    }

    public MarketplaceModel atualizar (MarketplaceModel produto){

        listaProdutos.removeIf(p -> p.getIdProduto() == produto.getIdProduto());

        listaProdutos.add(produto);

        
        return produto; 
    }

    public void deletar (Long id){
        listaProdutos.removeIf(p -> p.getIdProduto() == id);
    }

}
