package ru.ashcheulov.two;

import ru.ashcheulov.one.ClassOne;
import ru.ashcheulov.one.InterfaceOne;

/**
 *
 * @author Ashcheulov Mikhail
 */
public class ClassTwo {
    public void methodWithParam(InterfaceOne c) {
        System.out.print("ClassTwo(withParam):");
        System.out.println(c.printStr());
    }
    
    public void methodWithoutParam() {        
        ClassOne c = new ClassOne();        
        System.out.print("ClassTwo(withoutParam):");
        System.out.println(c.printStr());
    }
}