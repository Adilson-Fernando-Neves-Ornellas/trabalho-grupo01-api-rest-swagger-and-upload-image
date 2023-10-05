package com.serratec.trabalhogrupo01.model.Marketplace;

import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class MarketplaceModel {

    private Long idProduto;
    private String descricaoProd;
    private int qtdProd;
    private double valorVendaProd;
    private Date dataCadastroProd;
    private String imgBase64;
    
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
    public String getImgBase64() {
        return imgBase64;
    }
    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }
    

}
