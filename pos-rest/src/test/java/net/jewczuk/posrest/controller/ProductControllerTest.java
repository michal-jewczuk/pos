package net.jewczuk.posrest.controller;

import net.jewczuk.posrest.exception.ExceptionMessages;
import net.jewczuk.posrest.exception.ResourceNotFoundException;
import net.jewczuk.posrest.helper.MockHelper;
import net.jewczuk.posrest.service.ProductService;
import net.jewczuk.posrest.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;
import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Transactional
public class ProductControllerTest {

    private MockMvc mockMvc;

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = Mockito.mock(ProductServiceImpl.class);
        mockMvc = MockMvcBuilders
                .standaloneSetup(new ProductController(productService))
                .setControllerAdvice(new CustomExceptionHandler())
                .build();
    }

    @Nested
    @DisplayName("test all products")
    class AllProducts {

        @Test
        @DisplayName("should return empty list when there are no products")
        public void getEmptyList() throws Exception {
            when(productService.getAllProducts()).thenReturn(Collections.EMPTY_LIST);

            final ResultActions result = mockMvc.perform(get("/api/products"));

            result
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$", hasSize(0)));
        }

        @Test
        @DisplayName("should return all products")
        public void getAllProducts() throws Exception {
            when(productService.getAllProducts()).thenReturn(MockHelper.INSTANCE.getMockedProducts());

            final ResultActions result = mockMvc.perform(get("/api/products"));

            result
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$", hasSize(3)));
        }

        @Test
        @DisplayName("should redirect to no slash path")
        public void shouldRedirectToNoSlash() throws Exception {

            final ResultActions result = mockMvc.perform(get("/api/products/"));

            result
                    .andExpect(status().is3xxRedirection());
        }

    }

    @Nested
    @DisplayName("test single product")
    class SingleProduct {

        @Test
        @DisplayName("should return json when product exists")
        public void getExistingProduct() throws Exception {
            when(productService.getProductById(anyLong()))
                    .thenReturn(MockHelper.INSTANCE.getMockedProduct(1));

            final ResultActions result = mockMvc.perform(get("/api/products/2"));

            result
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.name", is("Product 2")))
                    .andExpect(jsonPath("$.price", is(2500)))
                    .andExpect(jsonPath("$.description", is("")))
                    .andExpect(jsonPath("$.image", is("")))
                    .andExpect(jsonPath("$.category.id", is(12)))
                    .andExpect(jsonPath("$.category.name", is("white")));
        }

        @Test
        @DisplayName("should return 404 when no product")
        public void shouldThrowNoResourceException() throws Exception {
            when(productService.getProductById(anyLong()))
                    .thenThrow(ResourceNotFoundException.class);

            final ResultActions result = mockMvc.perform(get("/api/products/2000"));

            result
                    .andExpect(status().isNotFound())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.error", is(ExceptionMessages.RESOURCE_NOT_FOUND.toString())));
        }

        @Test
        @DisplayName("should return bad request when path variable not a number")
        public void shouldThrowBadRequestException() throws Exception {
            final ResultActions result = mockMvc.perform(get("/api/products/test"));

            result
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.error", is(ExceptionMessages.INVALID_REQUEST_PARAMETERS.toString())));
        }

    }

}
