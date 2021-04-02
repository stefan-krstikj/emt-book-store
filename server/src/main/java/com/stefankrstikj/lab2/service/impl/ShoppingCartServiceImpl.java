package com.stefankrstikj.lab2.service.impl;

import com.stefankrstikj.lab2.model.Book;
import com.stefankrstikj.lab2.model.ShoppingCart;
import com.stefankrstikj.lab2.model.User;
import com.stefankrstikj.lab2.model.enumerations.ShoppingCartStatus;
import com.stefankrstikj.lab2.repository.ShoppingCartRepository;
import com.stefankrstikj.lab2.repository.UserRepository;
import com.stefankrstikj.lab2.service.BookService;
import com.stefankrstikj.lab2.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final com.stefankrstikj.lab2.service.BookService BookService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   UserRepository userRepository,
                                   BookService BookService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.BookService = BookService;
    }

    @Override
    public List<Book> listAllBooksInShoppingCart(Long cartId) throws Exception {
        if(this.shoppingCartRepository.findById(cartId).isEmpty())
            throw new Exception("Shopping cart not found");
        return this.shoppingCartRepository.findById(cartId).get().getBooks();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) throws Exception {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new Exception("User not found"));

        return this.shoppingCartRepository
                .findByUserAndStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }


    @Override
    public ShoppingCart addBookToShoppingCart(String username, Long BookId) throws Exception {
        ShoppingCart shoppingCart = getActiveShoppingCart(username);
        Book Book = this.BookService.findById(BookId);
        if(shoppingCart.getBooks()
                .stream().filter(i -> i.getId().equals(BookId)).count() > 0)
            throw new Exception("Book is already in shopping card");
        shoppingCart.getBooks().add(Book);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
