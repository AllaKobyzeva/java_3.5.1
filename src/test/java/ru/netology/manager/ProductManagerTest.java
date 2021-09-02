package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductManager manager = new ProductManager();
    Product book1 = new Book(1, "первая книга", 1000, "Пушкин");
    Product book2 = new Book(2, "вторая книга", 2020, "Лермонтов");
    Product book3 = new Book(3, "третья книга", 5555, "Лермонтов");
    Product smartphone1 = new Smartphone(4, "первый смартфон", 10111, "Samsung");
    Product smartphone2 = new Smartphone(5, "второй смартфон", 20111, "Honor");
    Product smartphone3 = new Smartphone(6, "третий смартфон", 15000, "Iphone");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldFindOneBookForAuthor() {

        Product[] actual = manager.searchBy("Пушкин");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTwoBooksForAuthor() {

        Product[] actual = manager.searchBy("Лермонтов");
        Product[] expected = new Product[]{book2, book3};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindSecondBookForName() {

        Product[] actual = manager.searchBy("вторая книга");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindAllSmartphonesForName() {

        Product[] actual = manager.searchBy("смартфон");
        Product[] expected = new Product[]{smartphone1,smartphone2,smartphone3};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindSmartphoneForProducer() {

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNOFindProducts() {

        Product[] actual = manager.searchBy("Тарелка");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}

