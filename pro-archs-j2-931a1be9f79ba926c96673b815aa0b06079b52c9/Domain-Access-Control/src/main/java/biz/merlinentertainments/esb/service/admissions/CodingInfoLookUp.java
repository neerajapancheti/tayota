package biz.merlinentertainments.esb.service.admissions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CodingInfoLookUp {


    public static final String DEFAULT_FILE_PATH = "translationTables/CodingInfoLookUpTable.txt";
    private static Map<String, String> codingInfoMap = new HashMap<String, String>();
    private static String mapFilePath;

    
    public CodingInfoLookUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String getMapFilePath() {
        if (mapFilePath == null) {
            return DEFAULT_FILE_PATH;
        }
        return mapFilePath;
    }

    public void setMapFilePath(String mapFilePath) {
        this.mapFilePath = mapFilePath;
    }

    public static void initMap() {
        String filePath = getMapFilePath();
        InputStream inputStream = CodingInfoLookUp.class.getClassLoader().getResourceAsStream(filePath);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line;
            while((line = br.readLine()) != null) {
                if (!line.toLowerCase().contains("root>")) {
                    String[] splittedString = line.split(",");
                    codingInfoMap.put(splittedString[0], splittedString[1]);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static String getCodingInfo(String key) {
    	if(codingInfoMap!=null || !(codingInfoMap.size()>0)) {
    		initMap();
    	}
        return codingInfoMap.get(key);
    }
}
