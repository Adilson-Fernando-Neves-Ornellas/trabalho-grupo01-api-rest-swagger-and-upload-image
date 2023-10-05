package com.serratec.trabalhogrupo01.repository.Produto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.serratec.trabalhogrupo01.model.Produto.ProdutosModel;

@Repository
public class ProdutosRepository {
    
    private List<ProdutosModel> listaProdutos = new ArrayList<>();
    private long ultimoId = 0; 

    public List<ProdutosModel> obterTodos(){
        return listaProdutos;
    }

    public ProdutosModel obter(Long id){
        
        ProdutosModel produtoEcontrado = null;

        for (ProdutosModel produto : listaProdutos){
            if(produto.getIdProduto() == id){
                produtoEcontrado = produto ;
            } 
        }

        return produtoEcontrado;
    }

    public ProdutosModel adicionar (ProdutosModel produto){

        ultimoId++;
        produto.setIdProduto(ultimoId);
        listaProdutos.add(produto);

        return produto; 
    }

    public ProdutosModel atualizar (ProdutosModel produto){

        listaProdutos.removeIf(p -> p.getIdProduto() == produto.getIdProduto());

        listaProdutos.add(produto);

        
        return produto; 
    }

    public void deletar (Long id){
        listaProdutos.removeIf(p -> p.getIdProduto() == id);
    }

}
