package com.zerefstbl.store.entrypoint.rest.api;

import com.zerefstbl.store.entrypoint.rest.dto.CreateProductRequest;
import com.zerefstbl.store.entrypoint.rest.dto.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/product")
@Tag(name = "Products")
public interface ProductAPI {

    @PostMapping
    @Operation(summary = "Create a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create Successfully"),
            @ApiResponse(responseCode = "400", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "Internal server error was thrown")
    })
    ResponseEntity<ProductResponse> createProduct(
            @Valid @RequestBody CreateProductRequest createProductRequest,
            HttpServletRequest httpServletRequest
    );


}
