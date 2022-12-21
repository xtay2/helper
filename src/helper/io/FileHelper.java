package helper.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

@SuppressWarnings("unused")
public class FileHelper {

	/**
	 * Writes a {@link CharSequence} to a {@link File} and creates all directories on that path.
	 */
	public static void write(Path path, CharSequence content) {
		try {
			if (path != null && content != null && !content.toString().isBlank()) {
				Files.createDirectories(path.getParent());
				Files.writeString(path, content);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Deletes a {@link File} or a {@link Directory} and all its contents.
	 *
	 * @return true if successful.
	 */
	@SuppressWarnings("ResultOfMethodCallIgnored")
	public static boolean delete(Path path) {
		try (var dirStream = Files.walk(path)) {
			dirStream.map(Path::toFile)
					.sorted(Comparator.reverseOrder())
					.forEach(File::delete);
			return true;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		}
	}
}
