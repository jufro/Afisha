package ru.netology.manager;

import ru.netology.domain.FilmItem;

public class FilmManager {
  private FilmItem[] items = new FilmItem[0];

  public void add(FilmItem item) {
    int length = items.length + 1;
    FilmItem[] tmp = new FilmItem[length];
    System.arraycopy(items, 0, tmp, 0, items.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }


  public FilmItem[] showFirstFilms(int count) {
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

}
