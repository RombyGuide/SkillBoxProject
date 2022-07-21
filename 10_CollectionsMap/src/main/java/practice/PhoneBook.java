package practice;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {
    Map<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // (рекомендуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (phone.matches("[\\d]{11}") && name.matches("[А-Яа-я]+")) {
            if (phoneBook.containsKey(phone)) {
                phoneBook.replace(phone, phoneBook.get(phone), name);
            } else {
                phoneBook.put(phone, name);

            }
        }
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        if (phoneBook.containsKey(phone)) {
            return phoneBook.get(phone) + " - " + phone;
        } else {
            return "";
        }
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        Set<String> setPhoneBook = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(name)) {
                setPhoneBook.add(name + " - " + entry.getKey());
            }
        }

        return setPhoneBook;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        TreeSet<String> treeSet = new TreeSet<>();
        String contact = "";

        for (String name : phoneBook.values()) {
            contact = name + " - ";
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                if (name.equals(entry.getValue())) {
                    contact = contact + ", " + entry.getKey();
                }
            }
            treeSet.add(contact.replaceAll(" ,", ""));
        }

        if (!treeSet.isEmpty()) {
            return treeSet;
        } else return new TreeSet<>();
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}