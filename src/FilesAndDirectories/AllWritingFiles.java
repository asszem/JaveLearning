package FilesAndDirectories;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

/**
 *
 * @author Andras Olah (olahandras78@gmail.com)
 */
public class AllWritingFiles {

	static boolean writingWithOutputStream(Path file, int content) {
		System.out.println("Writing binary data to file with default Standard Open Options.");
		System.out.println("Target file: " + file);
		try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(file))) {
			bos.write(content);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	static boolean writingWithOutputStreamWithOptions(Path file, int content) {
		System.out.println("Writing binary data to file with APPEND, CREATE Standard Open Option.");
		System.out.println("Target file: " + file);
		try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(file, APPEND, CREATE))) {
			bos.write(content);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	static boolean writingWithBufferedWriter(Path file, String outputContent, String openOption) {
		System.out.println("Writing character with UTF-16 encoding, standard opening options");
		System.out.println("Standard Open Option: " + openOption);
		System.out.println("Target file: " + file);
		switch (openOption.toLowerCase()) {
			case "append":
				try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file, Charset.forName("UTF-16"),CREATE, APPEND)) {
					System.out.println("Appending...");
					bufferedWriter.write(outputContent);
					bufferedWriter.newLine();
					return true;
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			default:
				try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file, Charset.forName("UTF-16"))) {
					bufferedWriter.write(outputContent);
					return true;
				} catch (IOException e) {
					e.printStackTrace();
				}
		}//end switch
		return false;
	}

	public static void waitForEnter() {
		try {
			System.out.println("Press Enter");
			System.in.read();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
