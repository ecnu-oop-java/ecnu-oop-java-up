import java.io.*;
import java.util.ArrayList;

/**
* 这个类用于文件读写，便于同学后续写作业的时候使用
* @author 王海洲,吴苑斌
* @version 1.0
*/

public class FileIO{
	public static void main(String args[]) {}
	
    /**
     * 这个方法将一个字符串追加地写入指定文件（支持中文）。
     * @param str String类型,要写入的字符。
     * @param fileName String类型, 文件名。
     * @exception Exception 输出流产生错误时。
     * @return void，无返回值。
     */
	public static void writeStringToFile(String str, String fileName) {
		BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "UTF-8"));
            bw.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}


    /**
     * 这个方法将读取指定文件的第pos个字符（支持中文）。
     * @param pos int类型, 要获取的字符的位置。
     * @param fileName String类型, 文件名。
     * @exception Exception 输入流产生错误或者文件不存在时。
     * @return char, 如果pos的值为负数或者大于文件内容长度，那么将返回0。如果正常，将返回该文件指定位置的字符。
     */
	public static char getCharFromFile(int pos, String fileName) {
        char res = 0;
        BufferedReader br = null;
        int len = 0;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            String temp = null;
            while((temp = br.readLine()) != null && pos >= 0) {   
                if(pos < temp.length()) {
                    res = temp.charAt(pos);
                }
                pos -= temp.length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return res;
	}

	
    /**
     * 这个方法将读取指定文件的第pos行的字符串（支持中文）。
     * @param pos int类型, 要获取的字符串的行的位置(从0开始)。
     * @param fileName String类型, 文件名。
     * @exception Exception 输入流产生错误或者文件不存在时。
     * @return String, 如果行下标pos为负数或者大于等于行数，那么将返回null。如果正常，将返回该文件指定行的字符串。
     */
	public static String getLineFromFile(int pos, String fileName) {
        BufferedReader br = null;
        String res = null;
        try {
            
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
		    String temp = null;
            int cnt = 0;
            while((temp = br.readLine()) != null && pos >= 0) {   
                if(pos == 0) {
                    res = temp;
                }
                pos--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return res;
	}


    /**
     * 这个方法将读取指定文件的所有行的字符串,并按照顺序储存在String类型数组中返回（支持中文）。
     * @param fileName String类型, 文件名。
     * @exception Exception 输入流产生错误或者文件不存在时。
     * @return String[], 文件中的内容将按照行号依次储存在String数组中。
     */
	public static String[] getAllLinesFromFile(String fileName) {
        int numLines = 0;
        BufferedReader br = null;
        ArrayList<String> strList = new ArrayList<String>();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

            String temp = null;
            while((temp = br.readLine()) != null){  
                strList.add(temp);
            }
            numLines = strList.size();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String[] res = new String[numLines];
        for(int i  = 0; i < numLines; i++) {
            res[i] = strList.get(i);
        }
		return res;
	}
}
