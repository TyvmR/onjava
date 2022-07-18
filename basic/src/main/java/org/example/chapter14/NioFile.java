package org.example.chapter14;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NioFile {



    static void visitDir(String dir) throws IOException {
//        Path path = Paths.get("C:\\Users\\Administrator\\IdeaProjects\\onjava\\basic\\src\\main\\resources\\dd.text");
        Path path = Paths.get("C:\\Users\\Administrator\\IdeaProjects\\onjava");
//        Stream<String> lines = Files.lines(path);
//        String collect = lines.collect(Collectors.joining("-"));
//        System.out.println(collect);

//        Files.lines(path).forEach(s -> System.out.println(s));
//
        try {
            Files.walkFileTree(path, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("=====start dir is========================"+dir.getFileName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("file is " + file.getFileName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.out.println("failed " + file.getFileName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println("===end dir is=========================="+dir.getFileName());

                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            visitDir("dd.text");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
