package concurrentExamples.chapter1;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable {

    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException {
        File list[] = file.listFiles();
        if (null != list) {
            for (File elementFile : list) {
                if (elementFile.isDirectory()) {
                    directoryProcess(elementFile);
                } else {
                    fileProcess(elementFile);
                }
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s: %s\n", Thread.currentThread().getName(),
                    file.getAbsolutePath());
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }
    }
    
    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("/Users/damonx", "javaeetutorial7.pdf");
        Thread thread = new Thread(searcher);
        thread.start();
        
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        thread.interrupt();
    }

}
