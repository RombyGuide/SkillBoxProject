package practice;

import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> arrayList = new ArrayList<>();

    public void add(String todo) {
        //  добавьте переданное дело в конец списка
        arrayList.add(todo);
    }

    public void add(int index, String todo) {
        //  добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index > -1 && index < arrayList.size()) {
            arrayList.add(index, todo);
            System.out.println("Добавлена работа \"" + todo + "\" с индексом " + index);
        } else if (index > arrayList.size()) {
            arrayList.add(todo);
        }
    }

    public void edit(int index, String todo) {
        //  заменить дело на index переданным индекс,
        //  проверьте возможность изменения
        if (index > -1 && index < arrayList.size()) {
            arrayList.set(index, todo);
            System.out.println("Работа под индексом " + index + " изменена на \"" + todo + "\"");
        } else {
            System.out.println("Неверная команда. Укажите индекс редактируемого дела" +
                    " значением не более " + (arrayList.size() - 1));
        }
    }

    public void delete(int index) {
        //  удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index > -1 && index < arrayList.size()) {
            arrayList.remove(index);
            System.out.println("Работа с индексом " + index + " удалена");
        } else {
            System.out.println("Неверная команда. Укажите индекс удаляемого дела" +
                    " значением не более " + (arrayList.size() - 1));
        }
    }

    public ArrayList<String> getTodos() {
        //  вернуть список дел
        System.out.println("Список дел:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("Работа номер: " + i + " " + arrayList.get(i));
        }
        return arrayList;
    }
}
