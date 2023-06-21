package com.petry.profile.Service;

import com.oreilly.servlet.multipart.FileRenamePolicy;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MyFileRenamePolicy implements FileRenamePolicy {
    @Override
    public File rename(File file) {
        String randomFileName = random();
        String name = file.getName();
        String body = null;
        String ext = null;

        int dot = name.lastIndexOf(".");
        if (dot != -1) {
            body = name.substring(0, dot);
            ext = name.substring(dot);
        } else {
            body = name;
            ext = "";
        }

        String tempName = randomFileName + ext;
        file = new File(file.getParent(), tempName);
        if (createNewFile(file)) {
            return file;
        }

        int count = 0;
        while ((!createNewFile(file)) && (count < 9999)) {
            count ++;
            file = new File(file.getParent(), randomFileName);
        }
        return file;
    }

    private boolean createNewFile(File file) {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public String random() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        char[] chs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        for (int i = 0; i < 16; i++) {
            builder.append(chs[random.nextInt(chs.length)]);
        }

        return builder.toString();
    }
}
