package helper.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

}
