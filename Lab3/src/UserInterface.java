import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UserInterface {
    public void readText(TextProcessor textP) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder line = new StringBuilder();
        String buffer;
        System.out.println("Enter your text: ");
        while (true) {
            buffer = br.readLine();
            if (buffer.equals("")) {
                break;
            }
            if (!line.toString().equals("")) {
                line.append(" ");
            }
            line.append(buffer);
        }
        textP.setText(line.toString());
    }

    public void output(TextProcessor t) {
        System.out.println("List of words from your text, sorted in alphabetical order :\n" + t.getSortedText());
    }
}