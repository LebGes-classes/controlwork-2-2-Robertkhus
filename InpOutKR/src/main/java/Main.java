import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TXTReader txtReader = new TXTReader();
        ArrayList<TVChanel> tvChanels = new ArrayList<>();
        txtReader.readTXT("data.txt", tvChanels);

        for (int i = 0; i < tvChanels.size(); i++) {
            Collections.sort(tvChanels.get(i).getBroadcastsTime());
        }

        for (int i = 0; i < tvChanels.size(); i++) {
            for (int j = 0; j < tvChanels.get(i).getBroadcastsTime().size(); j++) {
                System.out.println(tvChanels.get(i).getName().get(j));
                System.out.println(tvChanels.get(i).getBroadcastsTime().get(j).getHour());
            }
        }

        LocalTime curTime;
        for (int i = 0; i < tvChanels.size(); i++) {
            for (int j = 0; j < tvChanels.get(i).getBroadcastsTime().size(); j++) {
                if (LocalTime.now().getHour() == tvChanels.get(i).getBroadcastsTime().get(i).getHour()) {
                    System.out.println(tvChanels.get(i).getName().get(i));
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < tvChanels.size(); i++) {
            for (int j = 0; j < tvChanels.get(i).getBroadcastsTime().size(); j++) {
                if (tvChanels.get(i).getName().get(i).equals(scanner.nextLine())) {
                    System.out.println(tvChanels.get(i).getName().get(i));
                }
            }
        }

        int t1 = 9;
        int t2 = 22;
        for (int i = 0; i < tvChanels.size(); i++) {
            for (int j = 0; j < tvChanels.get(i).getBroadcastsTime().size(); j++) {
                if (tvChanels.get(i).getBroadcastsTime().get(i).getHour() > t1 && tvChanels.get(i).getBroadcastsTime().get(i).getHour() < t2) {
                    System.out.println(tvChanels.get(i).getName().get(i));
                }
            }
        }

        XLSXWriter xlsxWriter = new XLSXWriter(tvChanels);
        xlsxWriter.writeXLSX("KR.xlsx");
    }
}
