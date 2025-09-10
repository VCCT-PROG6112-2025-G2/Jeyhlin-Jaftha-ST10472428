import org.junit.Test;
import static org.junit.Assert.*;

public class SeriesTest {

    // 1. Search (Found)
    @Test
    public void testSearchSeries() {
        Series s = new Series();
        s.CaptureSeriesForTest("101", "Friends", "13", "10");
        assertNotNull(s.SearchSeriesById("101"));
    }

    // 2. Search (Not Found)
    @Test
    public void testSearchSeries_SeriesNotFound() {
        Series s = new Series();
        assertNull(s.SearchSeriesById("999"));
    }

    // 3. Update
    @Test
    public void testUpdateSeries() {
        Series s = new Series();
        s.CaptureSeriesForTest("102", "Lost", "15", "25");
        SeriesModel found = s.SearchSeriesById("102");

        // Simulate update
        found.setSeriesName("Lost Updated");
        found.setSeriesAge("16");
        found.setSeriesNumberOfEpisodes("30");

        assertEquals("Lost Updated", found.getSeriesName());
        assertEquals("16", found.getSeriesAge());
        assertEquals("30", found.getSeriesNumberOfEpisodes());
    }

    // 4. Delete (Found)
    @Test
    public void testDeleteSeries() {
        Series s = new Series();
        s.CaptureSeriesForTest("103", "Breaking Bad", "16", "62");
        assertNotNull(s.SearchSeriesById("103")); // confirm exists

        s.DeleteSeriesById("103");                // delete
        assertNull(s.SearchSeriesById("103"));    // confirm deleted
    }

    // 5. Delete (Not Found)
    @Test
    public void testDeleteSeries_SeriesNotFound() {
        Series s = new Series();
        s.DeleteSeriesById("999"); // deleting a non-existing series should be safe
        assertNull(s.SearchSeriesById("999"));
    }

    // 6. Age Restriction (Valid)
    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        Series s = new Series();
        assertTrue(s.isValidAge("12")); // within range
        assertTrue(s.isValidAge("2"));
        assertTrue(s.isValidAge("18"));
    }

    // 7. Age Restriction (Invalid)
    @Test
    public void testSeriesAgeRestriction_AgeInvalid() {
        Series s = new Series();
        assertFalse(s.isValidAge("1"));   // too low
        assertFalse(s.isValidAge("25"));  // too high
        assertFalse(s.isValidAge("abc")); // not a number
    }
}

