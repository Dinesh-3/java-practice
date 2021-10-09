package annotations;

import java.lang.annotation.*;

@Inherited // to make subclass also has this annotation
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

class SubClass extends AnnotationPractice {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        Mobile annotation = subClass.getClass().getAnnotation(Mobile.class);
        System.out.println("annotation.name() = " + annotation.name());
    }
}

class Practise {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
