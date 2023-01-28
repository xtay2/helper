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
	 * Deletes a {@link File} or a directory and all its contents.
	 *
	 * @return true if successful.
	 */
	public static boolean delete(Path path) {
		if (Files.notExists(path))
			return false;
		try (var dirStream = Files.walk(path)) {
			return dirStream.map(Path::toFile)
					.sorted(Comparator.reverseOrder())
					.reduce(true, (b, f) -> b && f.delete(), (b1, b2) -> b1 && b2 );
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		}
	}
}
