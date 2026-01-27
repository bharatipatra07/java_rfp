package EmployeePayroll;

import java.io.File;
import java.io.IOException;

public class EmployeePayrollService {

    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();

        service.checkFileExists();
        service.deleteFileAndVerify();
        service.createDirectory();
        service.createEmptyFile();
        service.listFilesAndDirectories();
        service.listFilesWithExtension(EmployeePayrollData.FILE_EXTENSION);
    }

    // 1.Check File Exists
    public void checkFileExists() {
        File file = new File(
                EmployeePayrollData.BASE_DIRECTORY,
                EmployeePayrollData.EMPTY_FILE_NAME
        );
        System.out.println("File exists: " + file.exists());
    }

    // 2.Delete File and Check Not Exists
    public void deleteFileAndVerify() {
        File file = new File(EmployeePayrollData.EMPTY_FILE_NAME);
        if (file.exists()) {
            boolean deleted = file.delete();
            System.out.println("File deleted: " + deleted);
        }
        System.out.println("File exists after delete: " + file.exists());
    }

    // 3.Create Directory
    public void createDirectory() {
        File directory = new File(EmployeePayrollData.BASE_DIRECTORY);
        if (!directory.exists()) {
            boolean created = directory.mkdir();
            System.out.println("Directory created: " + created);
        } else {
            System.out.println("Directory already exists");
        }
    }

    // 4.Create Empty File
    public void createEmptyFile() {
        File file = new File(
                EmployeePayrollData.BASE_DIRECTORY,
                EmployeePayrollData.EMPTY_FILE_NAME
        );

        try {
            if (file.createNewFile()) {
                System.out.println("Empty file created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    // 5.List Files and Directories
    public void listFilesAndDirectories() {
        File directory = new File(EmployeePayrollData.BASE_DIRECTORY);
        File[] files = directory.listFiles();

        System.out.println("\nListing files and directories:");
        if (files != null) {
            for (File file : files) {
                System.out.println(
                        (file.isDirectory() ? "[DIR] " : "[FILE] ")
                                + file.getName()
                );
            }
        }
    }

    // 6.List Files with Specific Extension
    public void listFilesWithExtension(String extension) {
        File directory = new File(EmployeePayrollData.BASE_DIRECTORY);
        File[] files = directory.listFiles();

        System.out.println("\nFiles with extension " + extension + ":");
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}
