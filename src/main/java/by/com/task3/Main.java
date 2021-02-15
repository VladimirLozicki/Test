package by.com.task3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Описание: SuffixingApp With Maven
 * Используйте maven для создания и управления простой программой Java с зависимостями.
 * Спецификация приложения:
 * Это приложение с суффиксами - небольшое Java-приложение, которое обращается к файлу конфигурации,
 * переименовывает набор файлов и переименовывает их, добавляя суффикс, указанный в той же конфигурации.
 * Детали:
 * Приложение должно прочитать файл конфигурации при запуске
 * Затем он должен убедиться, что все файлы из конфигурации существуют.
 * Затем он должен переименовать каждый файл, добавив суффикс из конфигурации к его имени
 * Он должен напечатать результаты переименования, например:   old_name -> new_name.
 * Шаги:
 * Создайте проект maven и укажите его настройки GAV, кодировку, уровень языка и т. Д.
 * Добавьте зависимость к некоторой библиотеке для чтения и анализа файлов JSON. (например, GSON)
 * Напишите код, реализующий спецификацию приложения.
 * Настройте проект maven для создания работающего jar-файла,содержащего приложение и его зависимости.
 */
public class Main {

    public static void main(String[] args) {

        Run run = new Run();
        Properties properties = run.asProperties("configuration.properties");
        String path = properties.getProperty("path");
        String suffix = properties.getProperty("suffix");
        String[] strings = properties.getProperty("fileNames").split(",");

        List<String> extended = new ArrayList<>();
        List<String> namesWithoutExtend = new ArrayList<>();
        List<File> renamedFiles = new ArrayList<>();

        for (String s : strings) {
            namesWithoutExtend.add(s.split("\\.")[0]);
            extended.add("." + s.split("\\.")[1]);
        }

        try {
            File file;
            int count = 0;
            for (String nameFile : strings) {
                file = new File(path + nameFile);
                if (file.isFile()) {
                    File newFile = new File(path + suffix + "_"+ namesWithoutExtend.get(count)  + extended.get(count));
                    if (file.renameTo(newFile)) {
                        renamedFiles.add(newFile);
                        count++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //разобраться как работает
//        run.replaceProperties("fileNames", "configuration.properties", "old.json,old.json",
//                "C:\\Users\\Professional\\Downloads\\modyl2\\modyl2\\src\\main\\resources\\configuration.properties");
        System.out.println(renamedFiles);
    }
}