package EmployeePayroll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class EmployeePayrollService {

    public static void main(String[] args) throws IOException, InterruptedException {
        EmployeePayrollService service = new EmployeePayrollService();

        service.watchDirectory(EmployeePayrollData.WATCH_DIRECTORY);
        service.countFileEntries();
    }

    // UC3: Watch Directory (including files & sub-directories)
    public void watchDirectory(String dirPath) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(dirPath);

        registerAll(path, watchService);

        System.out.println("Watching directory: " + path.toAbsolutePath());

        while (true) {
            WatchKey key = watchService.take();

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                Path changed = (Path) event.context();

                System.out.println(kind.name() + ": " + changed);
            }

            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }

    // Register directory and sub-directories
    private void registerAll(Path start, WatchService watchService) throws IOException {
        Files.walk(start)
                .filter(Files::isDirectory)
                .forEach(dir -> {
                    try {
                        dir.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
                    } catch (IOException e) {
                        System.out.println("Error registering directory: " + dir);
                    }
                });
    }

    // UC3: Count number of entries in file
    public void countFileEntries() {
        File file = new File(
                EmployeePayrollData.WATCH_DIRECTORY,
                EmployeePayrollData.FILE_TO_COUNT
        );

        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
                count++;
            }
            System.out.println("Number of entries in file: " + count);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
