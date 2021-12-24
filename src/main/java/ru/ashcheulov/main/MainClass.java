package ru.ashcheulov.main;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.ashcheulov.two.ClassTwo;

/**
 *
 * @author Ashcheulov Mikhail & Kravtcov Timofey
 */
public class MainClass {
    
    public static void main(String... a) {
        MyAwesomeClassLoader myAwesomeClassloader = new MyAwesomeClassLoader();
        myAwesomeClassloader.setPathToClasses("target/classes/");

        try {
            var objectForMyAwesomeClassLoader = myAwesomeClassloader.findClass("ru.ashcheulov.one.ClassOne").
                    getConstructor().newInstance();
            System.out.println("Class loader for object " + objectForMyAwesomeClassLoader + " : "+ objectForMyAwesomeClassLoader.getClass().getClassLoader().toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("First class wasn't found");
            return;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class is not ours");
            return;
        }

        ClassTwo objectForClassTwo = new ClassTwo();
        System.out.printf("Class loader for object %s : %s%n",objectForClassTwo, objectForClassTwo.getClass().getClassLoader().toString());
    }
}
