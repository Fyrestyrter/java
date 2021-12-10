import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Класс Pet.
class Pet {
    // Строка с именем.
    private final String name;

    // Метод получения имени.
    public String getName() {
        return name;
    }

    // Параметризированный конструктор.
    public Pet(String name) {
        this.name = name;
    }
}

// Класс Cat, наследуемый от Pet.
class Cat extends Pet {
    // Параметризированный конструктор.
    public Cat(String name) {
        super(name);
    }
}

// Класс Dog, наследуемый от Pet.
class Dog extends Pet {
    // Параметризированный конструктор.
    public Dog(String name) {
        super(name);
    }
}

// Класс Owl, наследуемый от Pet.
class Owl extends Pet {
    // Параметризированный конструктор.
    public Owl(String name) {
        super(name);
    }
}

public class Test {
    public static void main(String[] args) {
        // Инициализация объекта класса HaspMap.
        Map<String, Pet> hashMap = new HashMap<String, Pet>();

        // Добавление тестовых примеров.
        hashMap.put("Cat", new Cat("Frosya"));
        hashMap.put("Dog", new Dog("Barbos"));
        hashMap.put("Owl", new Owl("Yulya"));

        // Вывод всех элементов HaspMap'а.
        for (Map.Entry temp : hashMap.entrySet()) {
            System.out.println(temp.getKey() + "'s name is "
                    + ((Pet)temp.getValue()).getName());
        }

        // Проверяем наличие ключа в HaspMap'е.
        System.out.println("\"Owl\" enters? " + "Yes, it's " + hashMap.containsKey("Owl"));
        System.out.println("\"Elephant\" enters? " +"No, it's " + hashMap.containsKey("Elephant"));

        // Выводим значение по конкретному ключу.
        Pet cat = hashMap.get("Cat");
        System.out.println("\"Cat\" value is " + cat.getName());

        // Отображение.
        System.out.println(hashMap);


        // Инициализируем объект класса Random.
        Random random = new Random();

        // Инициализируем объект класса HaspMap.
        Map<Integer, Integer> randomHashMap = new HashMap<>();

        // Создадим 5 чисел.
        for (int i = 0; i < 5; i++){
            // Генерируем число от 0 до 100.
            int temp = random.nextInt(100);

            // Количество повторов.
            Integer freq = randomHashMap.get(temp);

            // Вносим в HashMap сгенерированное число.
            // Однако, так как все ключи уникальны, то перемещаем
            // индекс на единицу и записываем число.
            if (freq == null) randomHashMap.put(temp, 1);
                else randomHashMap.put(temp, freq + 1);
        }

        // Отображение.
        System.out.println(randomHashMap);
    }
}
