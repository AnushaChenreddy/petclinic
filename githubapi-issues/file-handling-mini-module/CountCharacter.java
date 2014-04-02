import java.io.*;
import java.nio.file.*;

/* The program expects an argument at runtime. 
 *  Even if a string is passed it takes the first character and gives the output.
 */

public class CountCharacter {

	Path textFile = Paths.get("C:\\Users\\Anusha\\Desktop"
			+ "\\Spring_2014\\Studio" + "\\CourseWork\\xanadu.txt");
	char inputCharacter;

	public static void main(final String[] args) throws Exception {
		CountCharacter countChar = new CountCharacter();
		try {
			countChar.runLogic(args[0]);
		} catch (Exception e) {
			System.out.println("please pass an argument!");
			System.err.println(e);
		}
	}

	CountCharacter(final char inputCharacter, final Path textFile) {
		this.inputCharacter = inputCharacter;
		this.textFile = textFile;
	}

	CountCharacter() {

	}

	public final void runLogic(final String inputChar) throws Exception {
		CountCharacter countCharacterObject = new CountCharacter(
				inputCharacter, textFile);

		countCharacterObject.inputCharacter = inputChar.charAt(0);
		int count = countCharacterObject.countNumberOfOccurences();
		System.out.format("The character '%c' has occured "
				+ "'%d' times in the file '%s'.%n",
				countCharacterObject.inputCharacter, count,
				countCharacterObject.textFile);

	}

	public final int countNumberOfOccurences() throws IOException {
		int count = 0;

		InputStream input = null;
		BufferedReader reader = null;
		try {
			input = Files.newInputStream(textFile);

			reader = new BufferedReader(new InputStreamReader(input));
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
		} finally {
			input.close();
			reader.close();
		}

		return count;
	}

}
