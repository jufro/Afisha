package ru.netology.manager;

import ru.netology.domain.FilmItem;
import ru.netology.repository.FilmRepository;

public class FilmManager {
  private FilmRepository repository;

  public FilmManager(FilmRepository repository) {
    this.repository = repository;
  }

  public void add(FilmItem item) {
    repository.save(item);
  }

  public FilmItem[] showFirstFilms(int count) {
    FilmItem[] items = repository.findAll();
    int defaultCount = 10;
    if (count <= 0){
      count = defaultCount;
    }
    if (count > items.length && defaultCount > items.length) {
      count = items.length;
    }
    FilmItem[] result = new FilmItem[count];
    for (int i = 0; i < count; i++) {
      int index = count - i - 1;
      result[i] = items[index];
    }
    return result;
  }

  public void removeById(int id) {
    repository.removeById(id);
  }

  public void removeAll() {
    repository.removeAll();
  }
}
