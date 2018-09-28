package constant.tools.batis.bind;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

public class Mai {

    public static void main(String[] args) {
        FileInputStream file = null;
        ;
        try {
            file = new FileInputStream(
                    "D:\\git\\constant\\constant\\trunk\\tools\\src\\test\\java\\constant\\tools\\batis\\bind\\426PDefects.ini");
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        try {
            List<String> s = IOUtils.readLines(file);
            Map<String, String> sss = new HashMap<String, String>(s.size());
            for (int i = 1; i < s.size(); i++) {
                String key = s.get(i).split("=")[1];
                String v = key;
                int l = key.split(" ")[0].length();
                if (1 == l) {
                    key = "0000" + key;
                } else if (2 == l) {
                    key = "000" + key;
                } else if (3 == l) {
                    key = "00" + key;
                } else if (4 == l) {
                    key = "0" + key;
                }
                
                sss.put(key, v);
            }
            List<String> sssk = new ArrayList<>(sss.keySet());

            Collections.sort(sssk);
            System.out.println(sssk);
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < sssk.size(); i++) {
                sb.append(i + "=" + sss.get(sssk.get(i)) + "\r\n");
            }
            FileWriter output = new FileWriter(
                    "D:\\git\\constant\\constant\\trunk\\tools\\src\\test\\java\\constant\\tools\\batis\\bind\\426_gen_PDefects.ini");

            IOUtils.write(sb.toString(), output);
            output.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
