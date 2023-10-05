package com.serratec.trabalhogrupo01.service.Marketplace;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.trabalhogrupo01.model.Marketplace.MarketplaceModel;
import com.serratec.trabalhogrupo01.repository.Marketplace.MarketplaceRepository;

@Service
public class MarketplaceService {
    
    @Autowired 
    private MarketplaceRepository produtosRepositoryAction;

    public List<MarketplaceModel> obterTodos(){
        return produtosRepositoryAction.obterTodos();
    }

    public MarketplaceModel obter(Long id){
        MarketplaceModel produto = produtosRepositoryAction.obter(id);
        if(produto==null){
            throw new InputMismatchException(id + " do produto não encontrado");
        }
        return produto;
    }

    public MarketplaceModel adicionar (MarketplaceModel produto){ 
        return produtosRepositoryAction.adicionar(produto);
    }

    public MarketplaceModel atualizar (long id, MarketplaceModel produto){

        MarketplaceModel produtoEncontrado = produtosRepositoryAction.obter(id);
        if(produtoEncontrado == null){
            throw new InputMismatchException("Erro ao tentar atualizar: "+ id + " do produto não encontrado");
        }
        produto.setIdProduto(id);
        return produtosRepositoryAction.atualizar(produto);
    }

    public void deletar (Long id){
        produtosRepositoryAction.deletar(id);
    }

}
