import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) {
        Person p1 = new Person("John Doe", 25);
        String filename = "person.ser";

        // Serialize the Object
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(p1);
            out.close();
            fileOut.close();
            System.out.println("Serailized data is saved in " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Person desirializedPersonObject = null;

        // Desirialzing the Object
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            desirializedPersonObject = (Person) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
             e.printStackTrace();
        }

        // Testing serialization
        if (desirializedPersonObject != null) {
            System.out.println("Deserialized person:");
            System.out.println("Name: " + desirializedPersonObject.getName());
            System.out.println("Age: " + desirializedPersonObject.getAge());
        }
    }
}
