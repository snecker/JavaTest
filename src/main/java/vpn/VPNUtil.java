package vpn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangpeng on 2015/7/5.
 */
public class VPNUtil {

    public static final String RASDIAL = "rasdial";

    public static boolean connectVPN(String localVPNName,String name,String password) throws IOException {
        String cmd = String.join(" ", RASDIAL,localVPNName, name, password);
        String result = exec(cmd);
        System.out.println("连接结果\n"+result);
        if(result!=null && result.contains("已连接")){
            return true;
        }
        return false;
    }

    public static boolean disconnectVPN(String localVPNName) throws IOException {
        String cmd = String.join(" ",RASDIAL,localVPNName,"/disconnect");
        String result = exec(cmd);
        System.out.println("取消连接结果\n"+result);
        if(result !=null && result.contains("没有连接")){
            return true;
        }
        return  false;
    }

    public static String exec(String cmd) throws IOException {
        Process pro = Runtime.getRuntime().exec("cmd /c "+cmd);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream(),"gbk"));
        String line = "";
        while ((line = br.readLine())!=null){
            sb.append(line);
        }
        return sb.toString();
    }
}
