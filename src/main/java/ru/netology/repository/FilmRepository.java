package ru.netology.repository;

import ru.netology.domain.FilmItem;

public class FilmRepository {
    private FilmItem[] items = new FilmItem[0];

    public void save(FilmItem item) {
        int length = items.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public FilmItem[] findAll() {
        return items;
    }

    public FilmItem findById(int filmId) {
        for (FilmItem item:items) {
            if (item.getId() == filmId) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int filmId) {
        int length = items.length - 1;
        FilmItem[] tmp = new FilmItem[length];
        int index = 0;
        for (FilmItem item : items) {
            if (item.getId() != filmId) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void removeAll() {
        FilmItem[] emptyRep = new FilmItem[0];
        items = emptyRep;
    }
}
