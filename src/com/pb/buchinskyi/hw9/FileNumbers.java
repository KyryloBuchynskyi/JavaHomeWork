package com.pb.buchinskyi.hw9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileNumbers {
    private String numPath;
    private String oddNumPath;
    Logger logger;

    public FileNumbers(String path, String oddNumPath) {
        this.numPath = path;
        this.oddNumPath = oddNumPath;
        logger = Logger.getLogger("Логи работы с файлом");
        logger.setLevel(Level.INFO);
        logger.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        logger.addHandler(consoleHandler);
    }

    //надо погуглить про создание папок, если еще не созданы
    public boolean createNumbersFile(int from, int to) {
        logger.log(Level.INFO, "Start function createNumbersFile");
        //Траим логирыванием 0_о
        try (FileWriter writer = new FileWriter(numPath, false)) {
            logger.log(Level.INFO, "FileWriter initialized");
            for (int i = from; i <= to; i++)
                if (i % 10 != 0) {
                    writer.write(i + "\t"); //не через пробел, так как через таб красивее=\
                    logger.log(Level.INFO, numPath + " add value");
                } else {
                    writer.write(i + "\n");
                    logger.log(Level.INFO, numPath + " add value");
                    logger.log(Level.INFO, numPath + " add new line");
                }
            logger.log(Level.INFO, numPath + " writing finished WO exceptions");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            logger.log(Level.INFO, numPath + " writing finished With exceptions: " + e.getMessage());
            return false;
        } finally {
            logger.log(Level.INFO, "FileWriter closed");
        }
        return true;
    }

    public boolean createOddNumbersFile() {
        logger.log(Level.INFO, "Start function createOddNumbersFile");
        try (Scanner reader = new Scanner(new File(numPath)); FileWriter writer = new FileWriter(oddNumPath, false)) {
            logger.log(Level.INFO, "Scanner initialized");
            logger.log(Level.INFO, "FileWriter initialized");
            while (reader.hasNextInt()) {
                logger.log(Level.INFO, numPath + " read number");
                int i = reader.nextInt();
                StringBuilder s = new StringBuilder();
                s.append(i % 2 == 0 ? 0 : i);
                s.append(i % 10 == 0 ? "\n" : "\t");
                writer.write(s.toString());
                logger.log(Level.INFO, oddNumPath + " add value");
            }
            logger.log(Level.INFO, oddNumPath + " writing finished WO exceptions");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.log(Level.INFO, oddNumPath + " writing finished With exceptions: " + e.getMessage());
            return false;
        } finally {
            logger.log(Level.INFO, "FileWriter closed");
            logger.log(Level.INFO, "Scanner closed");
        }
        return true;
    }
}
