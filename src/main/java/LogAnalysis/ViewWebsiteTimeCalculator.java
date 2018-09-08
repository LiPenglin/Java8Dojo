package LogAnalysis;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ViewWebsiteTimeCalculator {
    public static final int HALF_AN_HOUR = 1000 * 60 * 30;
    public static final String DD_MMM_YYYY_HH_MM_SS = "dd/MMM/yyyy:HH:mm:ss";

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat(DD_MMM_YYYY_HH_MM_SS);

    public static Date string2Timestamp(String timestampString) {
        try {
            return dateFormatter.parse(timestampString);
        } catch (ParseException e) {
            System.out.println("parse timestamp exception.");
        }
        return null;
    }

    public List<Long> load(String url) {
        try(Stream<String> lines = Files.lines(Paths.get(url))) {
            return  lines
                    .map(log -> log.split("\\[")[1])
                    .map(ViewWebsiteTimeCalculator::string2Timestamp)
                    .map(Date::getTime)
                    .sorted()
                    .collect(toList());

        } catch (Exception e) {
            System.out.println("read file exception.");
        }
        return null;
    }

    public ArrayList<String> calculate(List<Long> viewTimestamps) {
        ArrayList<String> independentViewInfos = new ArrayList<>();

        long firstView = viewTimestamps.get(0);
        long lastView = viewTimestamps.get(0);

        for (int i = 0; i < viewTimestamps.size(); i++) {
            long currentView = viewTimestamps.get(i);
            boolean isNotIndependentView = currentView - firstView > HALF_AN_HOUR;
            if (isNotIndependentView){
                independentViewInfos.add(dateFormatter.format(firstView) + "\t" + dateFormatter.format(lastView) + "\t" + (lastView - firstView));
                firstView = currentView;
            } else if ((i+1) == viewTimestamps.size()) {
                independentViewInfos.add(dateFormatter.format(firstView) + "\t" + dateFormatter.format(currentView) + "\t" + (currentView - firstView));
            }
            lastView = currentView;
        }

        return independentViewInfos;
    }
    public static void main(String[] args) {
        ViewWebsiteTimeCalculator calculator = new ViewWebsiteTimeCalculator();
        String url = "";
        calculator
                .calculate(calculator.load(url))
                .forEach(System.out::println);
    }
}
