package jp.itohiro.kata;

import jp.itohiro.kata.resource.FileKataTestResource;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static jp.itohiro.kata.resource.FileKataTestResource.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Ex1FileKata {

    @Rule
    public FileKataTestResource testResource = new FileKataTestResource();

    /**
     *  Create a path instance for "src/test/resources/io/file1".
     *  @see FileSystems#getDefault()
     *  @see FileSystem#getPath(String, String...)
     *  @see Paths#get(String, String...)
     */
    @Test
    public void test1PathInstantiation(){
        Path pathToFile1 = new File("src/test/resources/io/file1").toPath();
        Path pathToFile1FromFileSystem = null; //hint: create Path instance from FileSystems
        Path pathToFile1FromPaths = null; //hint: create Path instance from Paths

        assertThat("Hint: Create Path instance for \"src/test/resources/io/file1\" by using FileSystems",
                pathToFile1FromFileSystem,
                is(pathToFile1));
        assertThat("Hint: Create Path instance for \"src/test/resources/io/file\" by using Paths",
                pathToFile1FromPaths,
                is(pathToFile1));
    }

    /**
    *  Copy "src/test/resources/io/fileToCopy" to dist path.
    *  @see Files#copy(Path, Path, CopyOption...)
    */
    @Test
    public void test2CopyFile() throws Exception {
        Path dist = new File("src/test/resources/io/fileCopied").toPath();
        Path src = new File("src/test/resources/io/fileToCopy").toPath();

        //todo: write code to copy from src to dist

        assertTrue("Hint: Use Files.copy() method to copy src to dist",
                dist.toFile().exists());
        assertThat("Hint: Use Files.copy() method to copy src to dist",
                dist.toFile().getPath(),
                is("src/test/resources/io/fileCopied"));
        assertThat("Hint: Copy file from \"src/test/resources/io/fileToCopy\" file",
                Files.readAllLines(dist).get(0),
                is(COPY_FILE_CONTENTS));
    }

    /**
     *  Rename "src/test/resources/io/fileToRename" to "src/test/resources/io/fileRenamed".
     *  @see Files#move(Path, Path, CopyOption...)
     */
    @Test
    public void test3RenameFile() throws Exception {
        Path dist = new File("src/test/resources/io/fileRenamed").toPath();
        Path src = new File("src/test/resources/io/fileToRename").toPath();

        //todo: write code to rename from src to dist

        assertTrue("Hint: Use Files.move() method to rename from src to dist",
                dist.toFile().exists());
        assertThat("Hint: Use Files.move() method to rename from src to dist",
                dist.toFile().getPath(),
                is("src/test/resources/io/fileRenamed"));
        assertFalse("Hint: Use Files.move() instead of Files.copy()",
                src.toFile().exists());
        assertThat("Hint: Move file from \"src/test/resources/io/fileToRename\" file",
                Files.readAllLines(dist).get(0),
                is(RENAME_FILE_CONTENTS));
    }

    /**
     *  Move "src/test/resources/io/fileToMove" to "src/test/resources/io/dir1/fileMoved".
     *  @see Files#move(Path, Path, CopyOption...)
     */
    @Test
    public void test4MoveFile() throws Exception {
        Path dist = new File("src/test/resources/io/dir1/fileMoved").toPath();
        Path src = new File("src/test/resources/io/fileToMove").toPath();

        //todo: write code to move src file to dist

        assertTrue("Hint: Use Files.move() method to move src to dist",
                dist.toFile().exists());
        assertThat("Hint: Use Files.move() method to move src to dist",
                dist.toFile().getPath(),
                is("src/test/resources/io/dir1/fileMoved"));
        assertFalse("Hint: Use Files.move() instead of Files.copy()",
                src.toFile().exists());
        assertThat("Hint: Move file from \"src/test/resources/io/fileToMove\" file",
                Files.readAllLines(dist).get(0),
                is(MOVE_FILE_CONTENTS));
    }

    /**
     *  Read "src/test/resources/io/fileToRead" and set its contents to List.
     *  @see Files#readAllLines(Path)
     */
    @Test
    public void test5ReadFile() throws Exception {
        Path src = new File("src/test/resources/io/fileToRead").toPath();

        //todo: write code to read all lines from src path into a list of strings
        List<String> allLines = null;

        Assert.assertNotNull("Hint: Use Files#readAllLines(Path) to read \"src/test/resources/io/fileToRead\" file",
                allLines);
        assertThat("Hint: Use Files#readAllLines(Path) to read \"src/test/resources/io/fileToRead\" file",
                allLines.size(),
                is(1));
        assertThat("Hint: Use Files#readAllLines(Path) to read \"src/test/resources/io/fileToRead\" file",
                allLines.get(0),
                is(READ_FILE_CONTENTS));
    }

    /**
     *  Create a list of absolute path strings under "src/test/resources/io".
     *  @see Files#walk(Path, FileVisitOption...)
     */
    @Test
    public void test6WalkFilesAndCollectAbsolutePaths() throws Exception {
        Path src = new File(RESOURCE_DIR).toPath();

        //todo: write code to create a list of absolute path strings under src
        List<String> paths = null;

        paths.forEach(System.out::println);
        // Hint: the print statement above should generate outputs below
        // src/test/resources/io
        // src/test/resources/io/dir1
        // src/test/resources/io/dirToCopy
        // src/test/resources/io/dirToRecursiveCopy
        // src/test/resources/io/dirToRecursiveCopy/dir1
        // src/test/resources/io/dirToRecursiveCopy/dir1/file2
        // src/test/resources/io/dirToRecursiveCopy/dir2
        // src/test/resources/io/dirToRecursiveCopy/file1
        // src/test/resources/io/dirToRename
        // src/test/resources/io/file1
        // src/test/resources/io/fileToCopy
        // src/test/resources/io/fileToMove
        // src/test/resources/io/fileToRead
        // src/test/resources/io/fileToRename

        assertThat(paths.size(), is(DIRS.size() + FILES.size()));
        assertTrue(paths.containsAll(DIRS));
        assertTrue(paths.containsAll(FILES));
    }

    /**
     *  Create a list of relative path strings under "src/test/resources/io".
     *  @see Files#walk(Path, FileVisitOption...)
     */
    @Test
    public void test7WalkFilesAndCollectRelativePaths() throws Exception {
        Path src = new File(RESOURCE_DIR).toPath();

        //todo: write code to create a list of relative path strings under src
        List<String> paths = null;

        paths.forEach(System.out::println);
        // Hint: the print statement above should generate outputs below
        // (blank string)
        // dir1
        // dirToCopy
        // dirToRecursiveCopy
        // dirToRecursiveCopy/dir1
        // dirToRecursiveCopy/dir1/file2
        // dirToRecursiveCopy/dir2
        // dirToRecursiveCopy/file1
        // dirToRename
        // file1
        // fileToCopy
        // fileToMove
        // fileToRead
        // fileToRename

        assertThat(paths.size(), is(DIRS.size() + FILES.size()));
        assertTrue(paths.contains(""));
        assertTrue(paths.containsAll(DIRS.stream().filter(dir -> !dir.equals(RESOURCE_DIR)).map(s -> s.substring(RESOURCE_DIR.length() + 1)).collect(Collectors.toList())));
        assertTrue(paths.containsAll(FILES.stream().map(s -> s.substring(RESOURCE_DIR.length() + 1)).collect(Collectors.toList())));
    }

    /**
     *  Copy all files under "src/test/resources/io/dirToRecursiveCopy"
     *  to "src/test/resources/io/dirCopied".
     *  @see Files#walk(Path, FileVisitOption...)
     */
    @Test
    public void test8CopyDirectory() throws Exception {
        final Path dist = new File("src/test/resources/io/dirCopied").toPath();
        final Path src = new File("src/test/resources/io/dirToRecursiveCopy").toPath();

        //todo: write code to recursively copy files from src to dist

        assertTrue("Hint: Use Files.walk() method to walk through file tree and copy from src to dist",
                Paths.get("src/test/resources/io/dirCopied/dir1").toFile().exists());
        assertTrue("Hint: Use Files.move() method to walk through file tree and copy from src to dist",
                Paths.get("src/test/resources/io/dirCopied/dir1/file2").toFile().exists());
        assertTrue("Hint: Use Files.move() method to walk through file tree and copy from src to dist",
                Paths.get("src/test/resources/io/dirCopied/dir2").toFile().exists());
        assertTrue("Hint: Use Files.move() method to walk through file tree and copy from src to dist",
                Paths.get("src/test/resources/io/dirCopied/file1").toFile().exists());
    }
}
