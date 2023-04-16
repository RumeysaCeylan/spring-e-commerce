package com.example.commerce.presentation.rest;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.commerce.business.dto.CartDto;
import com.example.commerce.business.dto.CartProductDto;
import com.example.commerce.business.service.CartProductService;
import com.example.commerce.business.service.CartService;
import com.example.commerce.data.entity.Cart;
import com.example.commerce.data.entity.Cart.Status;
import com.example.commerce.data.entity.CartProduct;

import jakarta.transaction.Transactional;



@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
    private CartService cartService;

    @Autowired
    private CartProductService cartProductService;

    @GetMapping("/get/{id}")
    public CartDto getCart(@PathVariable long id) {
        Cart cart = cartService.findById(id).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setStatus(Status.NEW);
            return cartService.save(newCart);
        });

        return convertToDTO(cart);
    }
    @GetMapping("/cartProducts/{cartId}")
    public List<CartProduct> getCartProductsByCartId(@PathVariable("cartId") long cartId) {
        List<CartProduct> cartProducts = cartProductService.getDistinctCartProductsByCartId(cartId);
        return cartProducts;
    }
    @GetMapping("/latest")
    public ResponseEntity<Long> getLatestCartId() {
        Long latestCartId = cartService.getLatestCartId();
        return new ResponseEntity<>(latestCartId, HttpStatus.OK);
    }
   


    @PostMapping("/add/{cartid}/{productid}")
    public CartProductDto addProduct(@PathVariable("cartid") long cartid, @PathVariable("productid") long productid, @RequestBody CartProductDto cartProductDto) {

        Optional<Cart> existingCart = cartService.findById(cartid);
        
        Cart cart_ = cartService.getLatestCart();
        if (existingCart.isPresent()) {
        	
            if (cart_.getStatus() == Status.COMPLETED) {
                Cart newCart = new Cart();
                newCart.setCartId(cartid+1);
                newCart.setStatus(Status.NEW);
                cartService.save(newCart);
                CartProduct cartProduct = new CartProduct();
                cartProduct.setCart(newCart);
                cartProduct.setProductId(productid);
                cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());

                CartProduct savedCartProduct = cartProductService.save(cartProduct);
                return convertCartProductToDTO(savedCartProduct);
                
            } else {
            	Cart cart=existingCart.get();
                CartProduct cartProduct = new CartProduct();
                cartProduct.setCart(cart);
                cartProduct.setProductId(productid);
                cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());

                CartProduct savedCartProduct = cartProductService.save(cartProduct);
                return convertCartProductToDTO(savedCartProduct);
            }
        } else {
            Cart newCart = new Cart();
            newCart.setCartId(cartid+1);
            newCart.setStatus(Status.NEW);
            cartService.save(newCart);
            CartProduct cartProduct = new CartProduct();
            cartProduct.setCart(newCart);
            cartProduct.setProductId(productid);
            cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());

            CartProduct savedCartProduct = cartProductService.save(cartProduct);
            return convertCartProductToDTO(savedCartProduct);
            }


    }
    @Transactional
    @DeleteMapping("/remove/{cartid}/{productid}")
    public void removeProduct(@PathVariable("cartid") long cartid, @PathVariable("productid") long productid) {
        Cart cart = cartService.findById(cartid).orElseThrow(() -> new RuntimeException("Cart not found"));
        if (cart != null) {
            CartProduct cartProductToRemove = cart.getCartProducts().stream()
                    .filter(cp -> cp.getProductId() == productid) // Use '==' for primitive types
                    .findFirst()
                    .orElse(null);

            if (cartProductToRemove != null) {
                cartProductService.delete(cartProductToRemove);
                cart.getCartProducts().remove(cartProductToRemove);
                cartService.save(cart);
            }
        }    
        }

    @PutMapping("/checkout")
    public boolean checkout(@RequestBody CartDto cartDto) {
        Cart cart = cartService.findById(cartDto.getCartId()).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.setCustomerName(cartDto.getCustomerName());
        cart.setCardNumber(cartDto.getCardNumber());
        cart.setStatus(Status.COMPLETED);

        cartService.save(cart);
        return true;
    }

    // Helper methods for converting between DTOs and entities

    private CartDto convertToDTO(Cart cart) {
    	CartDto dto = new CartDto();
        dto.setCartId(cart.getCartId());
        dto.setCustomerName(cart.getCustomerName());
        dto.setCardNumber(cart.getCardNumber());
        dto.setStatus(cart.getStatus());
        List<CartProduct> cartProducts = cartProductService.findAllByCartId(cart.getCartId());
        dto.setCartProducts(cartProducts.stream()
                .map(cartProduct -> convertCartProductToDTO(cartProduct))
                .collect(Collectors.toList()));


        return dto;
    }

    private CartProductDto convertCartProductToDTO(CartProduct cartProduct) {
    	CartProductDto dto = new CartProductDto();
        dto.setCartProductId(cartProduct.getCartProductId());
        dto.setCartId(cartProduct.getCart().getCartId());
        dto.setProductId(cartProduct.getProductId());
        dto.setSalesQuantity(cartProduct.getSalesQuantity());

        return dto;
    }
  

}
