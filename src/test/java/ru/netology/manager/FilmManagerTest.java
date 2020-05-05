package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmItem;
import ru.netology.repository.Repository;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class FilmManagerTest {
    @Mock
    private Repository repository;
    @InjectMocks
    private FilmManager manager;
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
    void shouldShowFilms() {
        FilmItem[] returned = new FilmItem[]{first, second, third, forth, fifth, sixth, seventh};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{seventh, sixth, fifth, forth, third, second, first};
        FilmItem[] actual = manager.showFirstFilms(10);
        assertArrayEquals(expected, actual);
    }
}