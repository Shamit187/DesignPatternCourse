package Util;

import Font.Consolas;
import Font.CourierNew;
import Font.IFont;
import Font.Monaco;
import Parser.C;
import Parser.CPP;
import Parser.IParser;
import Parser.Python;

public class Editor {
    private static IParser parser;
    private static IFont font;
    private static String fileInit;

    public static String parse(String filename){
        String[] token = filename.split("\\.");
        switch (token[1]) {
            case "c":
                fileInit = token[0];
                parser = new C();
                font = new CourierNew();
                break;
            case "cpp":
                fileInit = token[0];
                parser = new CPP();
                font = new Monaco();
                break;
            case "py":
                fileInit = token[0];
                parser = new Python();
                font = new Consolas();
                break;
            case "exe":
                if(token[0].equals("info"))
                    return see();
                else if(token[0].equals("exit"))
                    return "";
            default:
                return "Invalid File Format";
        }
        return parser.see() + '\n' + font.see();
    }

    public static String see(){
        if(fileInit == null){
            return "Editor empty";
        }
        return "Filename: " + fileInit + " parsed\n" + parser.see() + '\n' + font.see();
    }


}
