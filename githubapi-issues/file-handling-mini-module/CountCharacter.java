import java.io.*;
import java.nio.file.*;

public class CountCharacter implements AutoCloseable {

	Path textFile = Paths.get("C:\\Users\\Anusha\\Desktop"
			+ "\\Spring_2014\\Studio" + "\\CourseWork\\xanadu.txt");
	char inputCharacter;

	public static void main(String[] args) throws Exception {
		CountCharacter countChar = new CountCharacter();
		try {
			countChar.runLogic(args[0]);
		} catch (Exception e) {
			System.out.println("please pass an argument!");
			System.err.println(e);
		}
	}

	CountCharacter(char inputCharacter, Path textFile) {
		this.inputCharacter = inputCharacter;
		this.textFile = textFile;
	}

	CountCharacter() {

	}
	
    @Override
    public void close() throws Exception {
        System.out.println("resources closed!");
    }

	public void runLogic(String inputChar) {
		CountCharacter countCharacterObject = new CountCharacter(
				inputCharacter, textFile);
		countCharacterObject.inputCharacter = inputChar.charAt(0);
		int count = countCharacterObject.countNumberOfOccurences();
		System.out.format("The character '%c' has occured "
				+ "'%d' times in the file '%s'.%n",
				countCharacterObject.inputCharacter, count,
				countCharacterObject.textFile);

	}

	public int countNumberOfOccurences() {
		int count = 0;
		try (InputStream in = Files.newInputStream(textFile);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in))) {
			String currentLine = null;
			while ((currentLine = reader.readLine()) != null) {
				for (int i = 0; i < currentLine.length(); i++) {
					if (inputCharacter == currentLine.charAt(i)) {
						count++;
					}
				}
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		return count;
	}

}
