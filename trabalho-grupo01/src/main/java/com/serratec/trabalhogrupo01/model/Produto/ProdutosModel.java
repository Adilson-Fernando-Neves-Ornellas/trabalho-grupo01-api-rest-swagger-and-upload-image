package com.serratec.trabalhogrupo01.model.Produto;

import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class ProdutosModel {

    private Long idProduto;
    private String descricaoProd;
    private int qtdProd;
    private double valorCustoProd;
    private double valorVendaProd;
    private Date dataCadastroProd;

    // getters and setters
    public Long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
    public String getDescricaoProd() {
        return descricaoProd;
    }
    public void setDescricaoProd(String descricaoProd) {
        this.descricaoProd = descricaoProd;
    }
    public int getQtdProd() {
        return qtdProd;
    }
    public void setQtdProd(int qtdProd) {
        this.qtdProd = qtdProd;
    }
    public double getValorCustoProd() {
        return valorCustoProd;
    }
    public void setValorCustoProd(double valorCustoProd) {
        this.valorCustoProd = valorCustoProd;
    }
    public double getValorVendaProd() {
        return valorVendaProd;
    }
    public void setValorVendaProd(double valorVendaProd) {
        this.valorVendaProd = valorVendaProd;
    }
    public Date getDataCadastroProd() {
        return dataCadastroProd;
    }
    public void setDataCadastroProd(Date dataCadastroProd) {
        this.dataCadastroProd = dataCadastroProd;
    }

}
