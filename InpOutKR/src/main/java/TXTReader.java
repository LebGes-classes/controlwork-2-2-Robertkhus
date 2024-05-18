import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TXTReader {
    public void readTXT (String filePath, ArrayList<TVChanel> tvProgramsList) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String str  = bufferedReader.readLine();
            TVChanel tvChanel;
            while (str != null) {
                if (str.charAt(0) == '#') {
                    tvChanel = new TVChanel();
                    tvChanel.setChanel(str.substring(1));
                    str = "";
                    while ((str = bufferedReader.readLine()) != null && str.charAt(0) != '#') {
                        BroadcastsTime broadcastsTime = new BroadcastsTime(Byte.parseByte(str.substring(0,2)), Byte.parseByte(str.substring(0,2)));
                        tvChanel.getBroadcastsTime().add(broadcastsTime);
                        tvChanel.getName().add(bufferedReader.readLine());
                    }
                    tvProgramsList.add(tvChanel);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
