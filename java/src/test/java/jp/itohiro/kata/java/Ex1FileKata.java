package jp.itohiro.kata.java;

import jp.itohiro.java.kata.kata.resource.FileKataTestResource;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.nio.file.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static jp.itohiro.java.kata.kata.resource.FileKataTestResource.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Ex1FileKata {

    @Rule
    public FileKataTestResource testResource = new FileKataTestResource();

    /**
     *  Create a path instance for "src/test/resources/ex1/file1".
     *  @see FileSystems#getDefault()
     *  @see FileSystem#getPath(String, String...)
     *  @see Paths#get(String, String...)
     */
    @Test
    public void test1PathInstantiation(){
        Path pathToFile1 = new File("src/test/resources/ex1/file1").toPath();
        Path pathToFile1FromFileSystem = null; //hint: create Path instance from FileSystems
        Path pathToFile1FromPaths = null; //hint: create Path instance from Paths

        assertThat("Hint: Create Path instance for \"src/test/resources/ex1/file1\" by using FileSystems",
                pathToFile1FromFileSystem,
                is(pathToFile1));
        assertThat("Hint: Create Path instance for \"src/test/resources/ex1/file\" by using Paths",
                pathToFile1FromPaths,
                is(pathToFile1));
    }

    /**
    *  Copy "src/test/resources/ex1/fileToCopy" to dist path.
    *  @see Files#copy(Path, Path, CopyOption...)
    */
    @Test
    public void test2CopyFile() throws Exception {
        Path dist = new File("src/test/resources/ex1/fileCopied").toPath();
        Path src = new File("src/test/resources/ex1/fileToCopy").toPath();

        //todo: write code to copy from src to dist

        assertTrue("Hint: Use Files.copy() method to copy src to dist",
                dist.toFile().exists());
        assertThat("Hint: Use Files.copy() method to copy src to dist",
                dist.toFile().getPath(),
                is("src/test/resources/ex1/fileCopied"));
        assertThat("Hint: Copy file from \"src/test/resources/ex1/fileToCopy\" file",
                Files.readAllLines(dist).get(0),
                is(COPY_FILE_CONTENTS));
    }

    /**
     *  Rename "src/test/resources/ex1/fileToRename" to "src/test/resources/ex1/fileRenamed".
     *  @see Files#move(Path, Path, CopyOption...)
     */
    @Test
    public void test3RenameFile() throws Exception {
        //todo: initialize dist and src
        Path dist = null; // Path instance for "src/test/resources/ex1/fileRenamed"
        Path src = null; // Path instance for "src/test/resources/ex1/fileToRename"

        assertNotNull("Hint: Instantiate dist object by using one of the methods learned in test1", dist);
        assertNotNull("Hint: Instantiate src object by using one of the methods learned in test1", src);

        //todo: write code to rename from src to dist

        assertTrue("Hint: Use Files.move() method to rename from src to dist",
                dist.toFile().exists());
        assertThat("Hint: Use Files.move() method to rename from src to dist",
                dist.toFile().getPath(),
                is("src/test/resources/ex1/fileRenamed"));
        assertFalse("Hint: Use Files.move() instead of Files.copy()",
                src.toFile().exists());
        assertThat("Hint: Move file from \"src/test/resources/ex1/fileToRename\" file",
                Files.readAllLines(dist).get(0),
                is(RENAME_FILE_CONTENTS));
    }

    /**
     *  Move "src/test/resources/ex1/fileToMove" to "src/test/resources/ex1/dir1/fileMoved".
     *  @see Files#move(Path, Path, CopyOption...)
     */
    @Test
    public void test4MoveFile() throws Exception {
        //todo: initialize dist and src
        Path dist = null; // Path instance for "src/test/resources/ex1/dir1/fileMoved"
        Path src = null; // Path instance for "src/test/resources/ex1/fileToMove"

        assertNotNull("Hint: Instantiate dist object by using one of the methods learned in test1", dist);
        assertNotNull("Hint: Instantiate src object by using one of the methods learned in test1", src);

        //todo: write code to move src file to dist

        assertTrue("Hint: Use Files.move() method to move src to dist",
                dist.toFile().exists());
        assertThat("Hint: Use Files.move() method to move src to dist",
                dist.toFile().getPath(),
                is("src/test/resources/ex1/dir1/fileMoved"));
        assertFalse("Hint: Use Files.move() instead of Files.copy()",
                src.toFile().exists());
        assertThat("Hint: Move file from \"src/test/resources/ex1/fileToMove\" file",
                Files.readAllLines(dist).get(0),
                is(MOVE_FILE_CONTENTS));
    }

    /**
     *  Read "src/test/resources/ex1/fileToRead" and set its contents to List.
     *  @see Files#readAllLines(Path)
     */
    @Test
    public void test5ReadFile() throws Exception {
        //todo: initialize src
        Path src = null; // Path instance for "src/test/resources/ex1/fileToRead"
        assertNotNull("Hint: Instantiate src object by using one of the methods learned in test1", src);

        //todo: write code to read all lines from src path into a list of strings
        List<String> allLines = null;

        Assert.assertNotNull("Hint: Use Files#readAllLines(Path) to read \"src/test/resources/ex1/fileToRead\" file",
                allLines);
        assertThat("Hint: Use Files#readAllLines(Path) to read \"src/test/resources/ex1/fileToRead\" file",
                allLines.size(),
                is(1));
        assertThat("Hint: Use Files#readAllLines(Path) to read \"src/test/resources/ex1/fileToRead\" file",
                allLines.get(0),
                is(READ_FILE_CONTENTS));
    }

    /**
     *  Create a list of absolute path strings under "src/test/resources/ex1".
     *  @see Files#walk(Path, FileVisitOption...)
     *  @see Stream#map(Function)
     *  @see Path#toString()
     *  @see Stream#collect(Collector)
     *  @see Collectors#toList()
     */
    @Test
    public void test6WalkFilesAndCollectAbsolutePaths() throws Exception {
        Path src = new File(RESOURCE_DIR).toPath();

        //todo: write code to create a list of absolute path strings under src
        List<String> paths = null;

        Assert.assertNotNull(
                "Hint: Leverage Files.walk(), Stream.map(), Path.toString(), " +
                        "Stream.collect() and Collectors.toList() to transform",
                paths);

        paths.forEach(System.out::println);
        // Hint: the print statement above should generate outputs below
        // src/test/resources/ex1
        // src/test/resources/ex1/dir1
        // src/test/resources/ex1/dirToCopy
        // src/test/resources/ex1/dirToRecursiveCopy
        // src/test/resources/ex1/dirToRecursiveCopy/dir1
        // src/test/resources/ex1/dirToRecursiveCopy/dir1/file2
        // src/test/resources/ex1/dirToRecursiveCopy/dir2
        // src/test/resources/ex1/dirToRecursiveCopy/file1
        // src/test/resources/ex1/dirToRename
        // src/test/resources/ex1/file1
        // src/test/resources/ex1/fileToCopy
        // src/test/resources/ex1/fileToMove
        // src/test/resources/ex1/fileToRead
        // src/test/resources/ex1/fileToRename

        assertThat(paths.size(), is(DIRS.size() + FILES.size()));
        assertTrue(paths.containsAll(DIRS));
        assertTrue(paths.containsAll(FILES));
    }

    /**
     *  Create a list of relative path strings under "src/test/resources/ex1".
     *  @see Files#walk(Path, FileVisitOption...)
     *  @see IntStream#range(int, int)
     *  @see Path#getNameCount()
     *  @see IntStream#mapToObj(IntFunction)
     *  @see Path#getName(int)
     *  @see Path#toString()
     *  @see Stream#collect(Collector)
     *  @see Collectors#joining(CharSequence)
     */
    @Test
    public void test7WalkFilesAndCollectRelativePaths() throws Exception {
        Path src = new File(RESOURCE_DIR).toPath();

        //todo: write code to create a list of relative path strings under src
        List<String> paths = null;

        Assert.assertNotNull(
                "Hint: Leverage Files.walk(), Intstream.range(), Path.getNameCount(), " +
                        "Intstream.mapToObj(), Path.getName(), Path.toString(), " +
                        "Stream.collect(), Collectors.joining() and Collectors.toList() to transform",
                paths);

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
     *  Copy all files under "src/test/resources/ex1/dirToRecursiveCopy"
     *  to "src/test/resources/ex1/dirCopied".
     *  @see Files#walk(Path, FileVisitOption...)
     */
    @Test
    public void test8CopyDirectory() throws Exception {
        final Path dist = new File("src/test/resources/ex1/dirCopied").toPath();
        final Path src = new File("src/test/resources/ex1/dirToRecursiveCopy").toPath();

        //todo: write code to recursively copy files from src to dist
        //todo: there are various ways to achieve this. figure out the way to do this yourself!

        assertTrue("Hint: Use Files.walk() method to walk through file tree and copy from src to dist",
                Paths.get("src/test/resources/ex1/dirCopied/dir1").toFile().exists());
        assertTrue("Hint: Use Files.move() method to walk through file tree and copy from src to dist",
                Paths.get("src/test/resources/ex1/dirCopied/dir1/file2").toFile().exists());
        assertTrue("Hint: Use Files.move() method to walk through file tree and copy from src to dist",
                Paths.get("src/test/resources/ex1/dirCopied/dir2").toFile().exists());
        assertTrue("Hint: Use Files.move() method to walk through file tree and copy from src to dist",
                Paths.get("src/test/resources/ex1/dirCopied/file1").toFile().exists());
    }
}
