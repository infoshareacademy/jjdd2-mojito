import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class testwczytywanie {
    public static void main(String argv[]) {
        try {
            File file = new File("nextbike-live.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println("Element główny:"
                    + doc.getDocumentElement().getNodeName());

    }
     catch (Exception e)

        e.printStakTrace();
    }
