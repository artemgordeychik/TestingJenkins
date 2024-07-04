package tests;

import org.testng.annotations.Test;

import java.lang.annotation.*;

public class AnnotationTest {
    @Test
    public void annotation() {
        Person person = new Person();
        Class personClass = person.getClass();
        Annotation testAnn = personClass.getAnnotation(JsonSerializable.class);
        JsonSerializable engine = (JsonSerializable) testAnn;
        System.out.println(engine.description());

    }

    //@Inherited
    //By default, an annotation cannot inherit from its superclass.
    // However, if we need to inherit an annotation from a superclass to a subclass, we use the
    //@Inherited annotation.
    @Retention(RetentionPolicy.RUNTIME)
    //RetentionPolicy.SOURCE— available at the source level and ignored by the compiler
    //RetentionPolicy.CLASS— available to the compiler at compile-time and ignored by the JVM
    //RetentionPolicy.RUNTIME— available to the JVM
    @Target(ElementType.TYPE)
    public @interface JsonSerializable {
        String description() default "Json description";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface JsonElement {
        public String key() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Init {
    }

    @JsonSerializable(description = "Person")
    public class Person {

        @JsonElement
        private String firstName;

        @JsonElement
        private String lastName;

        @JsonElement(key = "personAge")
        private String age;

        private String address;

        @Init
        private void initNames() {
            this.firstName = this.firstName.substring(0, 1).toUpperCase()
                    + this.firstName.substring(1);
            this.lastName = this.lastName.substring(0, 1).toUpperCase()
                    + this.lastName.substring(1);
        }

        // Standard getters and setters
    }


    @Inherited
    public @interface CustomAnnotation {  }
    @CustomAnnotation
    public class ParentClass {  }
    public class ChildClass extends ParentClass {  }
}
