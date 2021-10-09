package annotations;

// Java Program to Illustrate Retention Annotations

// Importing required classes from java.lang package
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Here we will be creating 3 annotations with
// RetentionPolicy as SOURCE, CLASS, & RUNTIME

// Retention Annotation 1
@Retention(RetentionPolicy.SOURCE)
@interface SourceRetention
{
    String value() default "Source Retention";
}

// Retention Annotation 2
@Retention(RetentionPolicy.CLASS)
@interface ClassRetention
{
    String value() default "Class Retention";
}

// Retention Annotation 3
@Retention(RetentionPolicy.RUNTIME)
@interface RuntimeRetention
{
    String value() default "Runtime Retention";
}

// Annotating classes A, B, and C
// with our custom annotations
@SourceRetention
class A {
}

@ClassRetention
class B {
}

@RuntimeRetention
class C {
};

// Main class
public class RetentionPolicyDemo {

    // Main driver method
    public static void main(String[] args)
    {

        /**
         * Obtaining the array of annotations used to
         * annotate class A, B, and C. Array a and b will be
         * empty as their annotation are attached before
         * runtime while array c will contain the
         * RuntimeRetention annotation as it was marked with
         * RUNTIME retention policy
         */
        Annotation a[]
                = new A().getClass().getAnnotations();
        Annotation b[]
                = new B().getClass().getAnnotations();
        Annotation c[]
                = new C().getClass().getAnnotations();

        // Printing the number of retained annotations of
        // each class at runtime
        System.out.println(
                "Number of annotations attached to "
                        + "class A RetentionPolicy.SOURCE at Runtime: " + a.length);

        System.out.println(
                "Number of annotations attached to "
                        + "class B RetentionPolicy.CLASS at Runtime: " + b.length);

        System.out.println(
                "Number of annotations attached to "
                        + "class C RetentionPolicy.RUNTIME at Runtime: " + c.length);

        /**
         * Since the class C is annotated with an annotation
         * which has retention policy as runtime, so it
         * can be accessed during runtime while annotations
         * of other two classes are discarded before runtime, so they can't be accessed
         */
        System.out.println(
                "Annotation attached to class C: " + c[0]);
    }
}
