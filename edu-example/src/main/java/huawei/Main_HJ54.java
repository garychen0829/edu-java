package huawei;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.Scanner;

/**
 * ScriptEngineManager 的使用
 */
public class Main_HJ54 {
    public static void main(String[] args) throws IOException, ScriptException {
        Scanner s  = new Scanner(System.in);
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String line = s.nextLine();
        System.out.print(engine.eval(line).toString());
    }
}


