package infoshareKurs;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DownloadFile {

    public static void main(String[] args) {

        String fromFile = "https://nextbike.net/maps/nextbike-live.xml";
        String toFile = "data/nextbike-live.xml";

        try {
            FileUtils.copyURLToFile(new URL(fromFile), new File(toFile), 10000, 10000);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
