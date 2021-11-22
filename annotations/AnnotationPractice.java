package annotations;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * SOURCE
 * public static final RetentionPolicy SOURCE
 * Annotations are to be discarded by the compiler.
 * CLASS
 * public static final RetentionPolicy CLASS
 * Annotations are to be recorded in the class file by the compiler but need not be retained by the VM at run time. This is the default behavior.
 * RUNTIME
 * public static final RetentionPolicy RUNTIME
 * Annotations are to be recorded in the class file by the compiler and retained by the VM at run time, so they may be read reflectively.
 *
 * Target -> https://stackoverflow.com/questions/3550292/what-do-java-annotation-elementtype-constants-mean/3550413
 */
@Inherited // to make subclass also has this annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Mobile{
    String name() default "";
    int version() default 1;
    String getName() default "1";
    static String toString = "Mobile Static Field";
}

@interface Car{

}

@Mobile(name = "MI", version = 1)
public class AnnotationPractice {
    public static void main(String[] args) {
        AnnotationPractice annotationPractice = new AnnotationPractice();
        Class<? extends AnnotationPractice> obj = annotationPractice.getClass();
        Annotation annotation = obj.getAnnotation(Mobile.class);

        System.out.println("obj.getAnnotations() = " + Arrays.toString(obj.getAnnotations()));
        System.out.println("annotation.annotationType() = " + annotation.annotationType());
        System.out.println("obj.isAnnotation() = " + obj.isAnnotation());
        System.out.println("obj.isAnnotationPresent(Mobile.class) = " + obj.isAnnotationPresent(Mobile.class));
        Mobile mobile = (Mobile) annotation;
        System.out.println("Mobile.toString = " + Mobile.toString);
        System.out.println("mobile.name(); = " + mobile.name());
        System.out.println("mobile.version() = " + mobile.version());
        System.out.println("mobile.toString() = " + mobile.toString());
        System.out.println("mobile.getClass() = " + mobile.getClass());
    }
}

class SubClass extends AnnotationPractice {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        Mobile annotation = subClass.getClass().getAnnotation(Mobile.class);
        System.out.println("annotation.name() = " + annotation.name());
    }
}

