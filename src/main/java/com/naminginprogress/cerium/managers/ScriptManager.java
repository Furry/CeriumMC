package com.naminginprogress.cerium.managers;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import com.google.common.collect.Lists;

public class ScriptManager {
    // singleton
    private static ScriptManager instance = new ScriptManager();
    public static ScriptManager getInstance() {
        return instance;
    }

    private ScriptManager() {
        
    }

    private void load(Path path) {
        System.out.println(path.toString());
    }

    private void loadPlugins() throws IOException {
        new File("./scripts").mkdir();
        Files.walk(new File("./scripts").toPath())
            .filter(path -> path.toString().endsWith(".js"))
            .forEach(path -> {
                if (path.endsWith(".js")) {
                    load(path);
                }
            });
    }
}
