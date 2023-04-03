package org.example.chapter14.test.java.org.example;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleEclipseConfigFiles {

    static final String[] dirs = {".settings"};
    static final String[] files = {".project",".classpath"};

    public static void main(String[] args) throws IOException {
//        Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
//        perms.add(PosixFilePermission.OWNER_READ);
//        perms.add(PosixFilePermission.OWNER_WRITE);
//        perms.add(PosixFilePermission.OWNER_EXECUTE);
//        perms.add(PosixFilePermission.GROUP_READ);
//        perms.add(PosixFilePermission.GROUP_WRITE);
//        perms.add(PosixFilePermission.GROUP_EXECUTE);
//        perms.add(PosixFilePermission.OTHERS_EXECUTE);
//        perms.add(PosixFilePermission.OTHERS_WRITE);
//        perms.add(PosixFilePermission.OTHERS_READ);

//        Path path = Paths.get("C:\\Users\\Administrator\\IdeaProjects\\onjava");
//        Files.setPosixFilePermissions(path,perms);
//        Path path = Paths.get("C:", "Users", "Administrator", "IdeaProjects", "aops_aopc_datalake_stream");
//        AclFileAttributeView aclView = Files.getFileAttributeView(path,
//                AclFileAttributeView.class);
//        if (aclView == null) {
//            System.out.format("ACL view  is not  supported.%n");
//            return;
//        }
//        try {
//            List<AclEntry> aclEntries = aclView.getAcl();
//            for (AclEntry entry : aclEntries) {
//                System.out.format("Principal: %s%n", entry.principal());
//                System.out.format("Type: %s%n", entry.type());
//                System.out.format("Permissions are:%n");
//                Set<AclEntryPermission> permissions = entry.permissions();
//                for (AclEntryPermission p : permissions) {
//                    System.out.format("%s %n", p);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Path path = Paths.get("C:\\Users\\Administrator\\IdeaProjects\\aops_aopc_datalake_stream");

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().equals(".project") || file.getFileName().toString().equals(".classpath") ||  file.getFileName().toString().contains("prefs")){
                    System.out.println("dele file");
                    Files.delete(file);

                }
                return super.visitFile(file,attrs);
            }



            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                if (dir.getFileName().toString().equals(".settings")){
                    System.out.println("dele dir");

                    Files.delete(dir);

                }
                return super.postVisitDirectory(dir,exc);
            }
        });

    }
}
