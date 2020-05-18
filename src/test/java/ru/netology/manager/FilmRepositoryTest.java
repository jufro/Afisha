package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FilmRepositoryTest {
    private Repository repository = new Repository();
    private FilmItem first = new FilmItem (1, "Bloodshot", "action");
    private FilmItem second = new FilmItem (2, "Onward", "cartoon");
    private FilmItem third = new FilmItem (3, "Hotel Belgrad", "comedy");
    private FilmItem forth = new FilmItem (4, "The Gentlemen", "action");
    private FilmItem fifth = new FilmItem (5, "The Invisible Man", "thriller");
    private FilmItem sixth = new FilmItem (6, "Trolls World Tour", "cartoon");
    private FilmItem seventh = new FilmItem (7, "Grudge", "thriller");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
    }


    @Test
    void showAllRepository() {
        FilmItem[] actual = repository.findAll();
        FilmItem[] expected = new FilmItem[]{first, second, third, forth, fifth, sixth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    void showById() {
        FilmItem actual = repository.findById(3);
        FilmItem expected = third;
        assertEquals(expected, actual);
    }

    @Test
    void showByIdIfNotInRepo() {
        FilmItem actual = repository.findById(10);
        FilmItem expected = null;
        assertEquals(expected, actual);
    }


    @Test
    void shouldRemoveById() {
        repository.removeById(1);
        FilmItem[] actual = repository.findAll();
        FilmItem[] expected = new FilmItem[]{second, third, forth, fifth, sixth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdIfNotInRepo() {
        repository.removeById(10);
        FilmItem[] actual = repository.findAll();
        FilmItem[] expected = new FilmItem[]{first, second, third, forth, fifth, sixth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        FilmItem[] actual = repository.findAll();
        FilmItem[] expected = new FilmItem[0];
        assertArrayEquals(expected, actual);
    }
}