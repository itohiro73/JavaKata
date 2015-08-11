package jp.itohiro.kata.resource;

import org.junit.rules.ExternalResource;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileKataTestResource extends ExternalResource{
    public static final String RESOURCE_DIR = "src/test/resources/ex1";

    public static final List<String> DIRS = Arrays.asList(
            "src/test/resources/ex1",
            "src/test/resources/ex1/dir1",
            "src/test/resources/ex1/dirToCopy",
            "src/test/resources/ex1/dirToRecursiveCopy",
            "src/test/resources/ex1/dirToRecursiveCopy/dir1",
            "src/test/resources/ex1/dirToRecursiveCopy/dir2",
            "src/test/resources/ex1/dirToRename"
    );

    public static final List<String> FILES = Arrays.asList(
            "src/test/resources/ex1/file1",
            "src/test/resources/ex1/fileToCopy",
            "src/test/resources/ex1/fileToMove",
            "src/test/resources/ex1/fileToRead",
            "src/test/resources/ex1/fileToRename",
            "src/test/resources/ex1/dirToRecursiveCopy/file1",
            "src/test/resources/ex1/dirToRecursiveCopy/dir1/file2"
    );
    public static final String READ_FILE_CONTENTS = "Hello Java World.";
    public static final String COPY_FILE_CONTENTS = "Correct copy file.";
    public static final String MOVE_FILE_CONTENTS = "Correct move file.";
    public static final String RENAME_FILE_CONTENTS = "Correct rename file.";

    @Override
    protected void before() throws Throwable {
        this.recreateFileResources();
    }

    @Override
    protected void after() {
        try {
            this.recreateFileResources();
        } catch (IOException e) {
            throw new RuntimeException("Clean-up might have failed..", e);
        }
    }

    private void recreateFileResources() throws IOException {
        this.clean(Paths.get(RESOURCE_DIR));
        DIRS.stream().forEach(dir -> {
            try {
                Files.createDirectory(Paths.get(dir));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        FILES.stream().forEach(file -> {
            try {
                Files.createFile(Paths.get(file));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        this.writeFileContents();
    }

    private void writeFileContents() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/test/resources/ex1/fileToRead"));
        writer.write(READ_FILE_CONTENTS);
        writer.close();
        writer = Files.newBufferedWriter(Paths.get("src/test/resources/ex1/fileToCopy"));
        writer.write(COPY_FILE_CONTENTS);
        writer.close();
        writer = Files.newBufferedWriter(Paths.get("src/test/resources/ex1/fileToMove"));
        writer.write(MOVE_FILE_CONTENTS);
        writer.close();
        writer = Files.newBufferedWriter(Paths.get("src/test/resources/ex1/fileToRename"));
        writer.write(RENAME_FILE_CONTENTS);
        writer.close();

    }

    private void clean(Path path) throws IOException {
        if(!Files.exists(path)){
            return;
        }
        if(Files.isRegularFile(path)){
            Files.delete(path);
        }
        else{
            Files.list(path).forEach(eachPath -> {
                try {
                    clean(eachPath);
                } catch (IOException e) {
                    throw new RuntimeException("Resources may not have been cleaned-up... " +
                            "Manually delete files under \"src/test/resources/ex1\" and rerun", e);
                }
            });
            Files.delete(path);
        }
    }
}

