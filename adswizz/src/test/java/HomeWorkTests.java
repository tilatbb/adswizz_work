import com.ex.data.Opportunity;
import com.ex.data.Records;
import com.ex.utils.AssertValues;
import com.ex.utils.UtilsFunctions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeWorkTests {

    private final String DEVICE_ASSERT_VALUE = "mobiles & tablets";
    private final String MOST_POPULAR_SHOW_ASSERT_VALUE = "Who Trolled Amber";

    @Test
    public void mostListenedShowInACity() {
        UtilsFunctions parseFile = new UtilsFunctions();
        List<Records> onlySanFranciscoRecords = parseFile.getFilteredListByCity("san francisco");
        Map<String, Integer> shows = new HashMap<>();

        for (Records record : onlySanFranciscoRecords) {
            shows.put(record.getDownloadIdentifier().getShowId(), shows.getOrDefault(record.getDownloadIdentifier().getShowId(), 0) + 1);
        }

        String mostPopularShow = null;
        int downloads = 0;
        for (Map.Entry<String, Integer> entry : shows.entrySet()) {
            if (entry.getValue() > downloads) {
                mostPopularShow = entry.getKey();
                downloads = entry.getValue();
            }
        }
        assertEquals(downloads, 24);
        assertEquals(mostPopularShow, MOST_POPULAR_SHOW_ASSERT_VALUE);
        System.out.println("Most popular show is: " + mostPopularShow);
        System.out.println("Number of downloads is: " + downloads );
    }

    @Test
    public void checkTheBestDevice() {
        UtilsFunctions parseFile = new UtilsFunctions();
        List<Records> records = parseFile.getAllRecords();
        Map<String, Integer> deviceCount = new HashMap<>();

        for (Records record : records) {
            deviceCount.put(record.getDeviceType(), deviceCount.getOrDefault(record.getDeviceType(), 0) + 1);
        }

        String mostFrequentDevice = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : deviceCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequentDevice = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        assertEquals(maxCount, 60);
        assertEquals(mostFrequentDevice, DEVICE_ASSERT_VALUE);
        System.out.println("Most popular device is: " + mostFrequentDevice);
        System.out.println("Number of downloads is: " + maxCount );
    }

    @Test
    public void opportunityInPrerollTest() {
        UtilsFunctions parseFile = new UtilsFunctions();
        List<Records> records = parseFile.getAllRecords();
        Map<String, Integer> prerollCounts = new HashMap<>();

        for (Records data : records) {
            String showId = data.downloadIdentifier.showId;

            for (Opportunity opportunity : data.opportunities) {
                List<String> adBreakIndices = List.of(opportunity.getPositionUrlSegments().get("aw_0_ais.adBreakIndex"));
                if (adBreakIndices != null && adBreakIndices.contains("preroll")) {
                    prerollCounts.put(showId, prerollCounts.getOrDefault(showId, 0) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(prerollCounts.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            assertEquals(entry.getValue(), AssertValues.getValueByShow(entry.getKey()));
            System.out.println("Show Id: " + entry.getKey() + ", Preroll Opportunity Number: " + entry.getValue());
        }
    }


}


