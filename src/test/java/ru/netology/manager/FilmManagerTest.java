package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;
import ru.netology.manager.FilmManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FilmManagerTest {
    private FilmManager manager = new FilmManager();
    private FilmItem first = new FilmItem(1, "Bloodshot", "action");
    private FilmItem second = new FilmItem(2, "Onward", "cartoon");
    private FilmItem third = new FilmItem(3, "Hotel Belgrad", "comedy");
    private FilmItem forth = new FilmItem(4, "The Gentlemen", "action");
    private FilmItem fifth = new FilmItem(5, "The Invisible Man", "thriller");
    private FilmItem sixth = new FilmItem(6, "Trolls World Tour", "cartoon");
    private FilmItem seventh = new FilmItem(7, "Grudge", "thriller");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
    }


    @Test
    void showFirstFilmsIfZero() {
        FilmItem[] actual = manager.showFirstFilms(0);
        FilmItem[] expected = new FilmItem[]{seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void showFirstFilmsIfMoreThanLength() {
        FilmItem[] actual = manager.showFirstFilms(10);
        FilmItem[] expected = new FilmItem[]{seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void showFirstFilmsIfLessThanTen() {
        FilmItem[] actual = manager.showFirstFilms(7);
        FilmItem[] expected = new FilmItem[]{seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void showFirstFilmsIfLessThanLength() {
        FilmItem[] actual = manager.showFirstFilms(5);
        FilmItem[] expected = new FilmItem[]{fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void showFirstFilmsIfLessThanZero() {
        FilmItem[] actual = manager.showFirstFilms(-1);
        FilmItem[] expected = new FilmItem[]{seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}