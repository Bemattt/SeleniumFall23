package com.fall23.ui.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {

    private static Properties properties;

    private configReader() {
    // Singleton
    }
    //Этот код определяет класс с именем configReader.
    //Он имеет приватное статическое поле properties, которое является объектом типа Properties.
    //Также в классе есть приватный конструктор configReader(), который не делает ничего, потому
    // что он используется для реализации шаблона проектирования Singleton.
    //Теперь давайте объясним, что такое Singleton.
    //Singleton - это шаблон проектирования, который гарантирует, что у класса есть только один экземпляр (объект),
    // и предоставляет глобальную точку доступа к этому экземпляру.
    //
    //В данном случае, приватный конструктор configReader() означает,
    //что никто не может создать экземпляр этого класса снаружи класса.
    //Однако, также имеется статическое поле properties, которое может быть использовано
    //для хранения информации о конфигурации (например, настроек программы).
    //Таким образом, при использовании этого класса, вы не создаете новый объект configReader каждый раз,
    //а используете один и тот же объект, который был создан ранее.
    //Это позволяет избежать создания дублирующихся объектов и обеспечивает доступ к одному и тому же
    //экземпляру класса из разных частей программы.

    static {
        try {
            String path = "src/main/resources/application.properties";
            FileInputStream inputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e){
            throw new RuntimeException("File not found");
        }
    }

    //Код, который вы предоставили, представляет собой статический блок инициализации.
    // Этот блок кода выполняется один раз, когда класс загружается в память,
    // и предназначен для инициализации статических полей класса.
    //
    //Давайте разберем этот код по шагам:
    //
    //String path = "src/main/resources/application.properties";: Здесь определяется путь к файлу application.properties.
    // Этот файл, вероятно, содержит какие-то конфигурационные настройки для вашей программы.
    //FileInputStream inputStream = new FileInputStream(path);: Создается объект FileInputStream для чтения файла по указанному пути.
    //properties = new Properties();: Создается новый объект Properties, который будет использоваться для хранения ключ-значение пар из файла.
    //properties.load(inputStream);: Содержимое файла application.properties загружается в объект properties, используя метод load(). Этот метод читает содержимое файла и парсит его, заполняя объект properties соответствующими данными.
    //inputStream.close();: После того как содержимое файла загружено в объект properties, поток чтения закрывается для освобождения ресурсов.
    //catch (IOException e) { throw new RuntimeException(e); }: Если в процессе выполнения какая-либо ошибка произойдет при чтении файла (например, если файл не найден), программа выбросит исключение типа RuntimeException, чтобы сообщить о проблеме.
    //Таким образом, этот статический блок инициализации загружает содержимое файла application.properties в объект properties, который затем можно использовать для доступа к конфигурационным настройкам программы в других частях кода.

    public static String getValue(String key){
        return properties.getProperty(key).trim();
    }
}
