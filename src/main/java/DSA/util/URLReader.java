package DSA.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
    public static BufferedReader readURL(String url) throws IOException {

        URL urlObj = new URL(url);
        InputStream inputStream = urlObj.openStream();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream)
        );
        return bufferedReader;
    }
}
