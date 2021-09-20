package annotations;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Mobile{
    String name() default "";
    int version() default 1;
    String getName() default "1";
}

@Mobile(name = "MI", version = 1)
public class AnnotationPractice {
    public static void main(String[] args) {
        AnnotationPractice annot = new AnnotationPractice();
        Class obj = annot.getClass();
        Annotation annotation = obj.getAnnotation(Mobile.class);
        // isAnnotationPresent
        Mobile mobile = (Mobile) annotation;
        String name = mobile.name();
        System.out.println("name = " + name);
        System.out.println(mobile.version());
    }
}

class Practise {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
