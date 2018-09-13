package com.ilepeskevicius;

import Base.EmailSender;
import org.testng.TestNG;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] argv){

        // test "/var/tmp" directory
        File tmpDir = new File("test-output");
        boolean exists = tmpDir.exists();
        if (exists) {
            System.out.println("/test-output exists from a previous run, it will be deleted");
            deleteFile(tmpDir);
        }

         TestNG runner = new TestNG();
         List<String> suitefiles = new ArrayList<String>();
         suitefiles.add("testng.xml");
         runner.setTestSuites(suitefiles);
         runner.run();

         if (runner.hasFailure()){
            EmailSender.main();
         }

        }

    private static void deleteFile(File element) {
        if (element.isDirectory()) {
            for (File sub : element.listFiles()) {
                deleteFile(sub);
            }
        }
        element.delete();
    }
}


