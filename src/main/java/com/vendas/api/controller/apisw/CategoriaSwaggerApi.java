package com.vendas.api.controller.apisw;

import com.vendas.api.model.Categoria;
import com.vendas.api.model.dto.CategoriaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(value = "Categorias", tags = "Categorias")
@RequestMapping(value = "categorias/api")
public interface CategoriaSwaggerApi {

    @ApiOperation(value = "Listar todas categorias")
    @GetMapping
    public List<Categoria> todas();

    @ApiOperation(value = "Buscar categoria por id")
    @GetMapping(path = "buscar-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria findById(@PathVariable Long id);

    @ApiOperation(value = "Atualizar categoria")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Categoria update(@RequestBody @Valid Categoria categoria);
    
    @ApiOperation(value = "Apagar categoria")
    @DeleteMapping("excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id", required = true) Long id);
    
    @ApiOperation(value = "Salvar categoria")
    @PostMapping()
    public CategoriaDTO salvar(@Valid @RequestBody CategoriaDTO categoriaDTO);

}

//@ApiOperation(value = "The Read Consent API is a resource that conforms to a RESTful syntax to retrieve the details of a single consent record.", nickname = "getConsent", notes = "Cannot read without parameters. Minimum of 2 characters in each field. Maximum of 50 characters in each field. Should be able to handle special characters.", response = Consent.class, tags = {"consent",})
//@ApiResponses(value = {
//        @ApiResponse(code = 200, message = "OK", response = Consent.class),
//        @ApiResponse(code = 400, message = "Bad Request"),
//        @ApiResponse(code = 405, message = "Method Not Allowed"),
//        @ApiResponse(code = 500, message = "Internal Server Error"),
//        @ApiResponse(code = 604, message = "Could Not Retrieve Data for Consent"),
//        @ApiResponse(code = 714, message = "Consent Not Found Matching Input Values")})
//@RequestMapping(value = "/consent/read",
//        method = RequestMethod.POST,
//        consumes = {MediaType.APPLICATION_JSON_VALUE},
//        produces = {MediaType.APPLICATION_JSON_VALUE})
//ResponseEntity<?> getConsent(@ApiParam(value = "Identifier for the consent object to be retrieved.", required = true) @Valid @RequestBody ConsentReadRequestParent consentReadRequestParent);
