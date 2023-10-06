package com.serratec.trabalhogrupo01.controller.Marketplace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.serratec.trabalhogrupo01.model.Marketplace.MarketplaceModel;
import com.serratec.trabalhogrupo01.service.Marketplace.MarketplaceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/marketplace")
@Api(value = "marketplace")
public class MarketplaceController {
     
    @Autowired
    private MarketplaceService marketplaceServiceAction;

    @GetMapping
    @ApiOperation(value = "RETORNA UMA LISTA DE PRODUTOS ")
    public ResponseEntity<List<MarketplaceModel>> obterTodos(){
        List<MarketplaceModel> listaProd = marketplaceServiceAction.obterTodos();
        return  ResponseEntity.ok(listaProd);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "RETORNA UM PRODUTO ESPECIFICO PELA ID")
    public ResponseEntity<MarketplaceModel> obter(@PathVariable Long id){
        return ResponseEntity.ok(marketplaceServiceAction.obter(id));
    }

    @PostMapping
    @ApiOperation(value = "ADICIONA UM PRODUTO")
    public ResponseEntity<MarketplaceModel> adicionar (@RequestBody MarketplaceModel produto){ 
        MarketplaceModel prodAdicionado = marketplaceServiceAction.adicionar(produto);
        return new ResponseEntity<>(prodAdicionado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "ATUALIZA UM PRODUTO")
    public ResponseEntity<MarketplaceModel> atualizar (@PathVariable long id, @RequestBody MarketplaceModel produto){
        MarketplaceModel produAtualizado = marketplaceServiceAction.atualizar(id, produto);
        return ResponseEntity.ok(produAtualizado);        
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "DELETA UM PRODUTO")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        marketplaceServiceAction.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ______________________________________________________________________

    // Define uma constante UPLOAD_DIRECTORY que armazena o diretório de upload como o diretório atual do sistema + "/Uploads"
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/Uploads";
    
    @PostMapping("/upload/{id}")
    @ApiOperation(value = "FAZER UPLOAD DE UMA IMAGEM LIGADA A UM PRODUTO ESPECIFICO")
    public void uploadImage(@RequestParam("image") MultipartFile file, @PathVariable long id) throws IOException { 
        
        // Define o caminho completo (Path) para o arquivo a ser salvo, com base no diretório de upload e no nome de arquivo original
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());

        // Obtém um produto do mercado com base no ID fornecido
        MarketplaceModel prdutoEncontrado = marketplaceServiceAction.obter(id);
        // Define o nome do arquivo no produto com base no nome original do arquivo
        prdutoEncontrado.setNomeFile(file.getOriginalFilename());
        // Define o caminho do arquivo no produto com base no diretório de upload e no nome do arquivo
        prdutoEncontrado.setPathFile(UPLOAD_DIRECTORY + "/" + prdutoEncontrado.getNomeFile());
        // Atualiza o produto no serviço do mercado
        marketplaceServiceAction.atualizar(id, prdutoEncontrado);
    }
}
