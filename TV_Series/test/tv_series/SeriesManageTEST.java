/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package tv_series;


import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author RC_Student_lab
 */
public class SeriesManageTEST {
    private SeriesManage service;

    @Before
    public void setup() {
        service = new SeriesManage();
        service.clearAll(); // ensure empty list
        service.addSeries(new SeriesModel("S001", "Loki", "13", "10"));
    }

    @Test
    public void TestSearchSeries() {
        SeriesModel result = service.searchSeries("S001");
        assertNotNull("Series should be found", result);
        assertEquals("Loki", result.SeriesName);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        SeriesModel result = service.searchSeries("S999");
        assertNull("Series should not be found", result);
    }

    @Test
    public void TestUpdateSeries() {
        boolean updated = service.updateSeries("S001", "Loki Season 2", "15", "12");
        assertTrue("Series should be updated", updated);
        SeriesModel updatedSeries = service.searchSeries("S001");
        assertEquals("Loki Season 2", updatedSeries.SeriesName);
        assertEquals("15", updatedSeries.SeriesAge);
        assertEquals("12", updatedSeries.SeriesNumberOfEpisodes);
    }

    @Test
    public void TestDeleteSeries() {
        boolean deleted = service.deleteSeries("S001");
        assertTrue("Series should be deleted", deleted);
        assertNull(service.searchSeries("S001"));
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        boolean deleted = service.deleteSeries("S999");
        assertFalse("No series should be deleted", deleted);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        assertTrue("Age should be valid", service.isValidAge("10"));
        assertTrue("Age should be valid", service.isValidAge("18"));
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        assertFalse("Age below range should be invalid", service.isValidAge("1"));
        assertFalse("Age above range should be invalid", service.isValidAge("19"));
        assertFalse("Non-numeric age should be invalid", service.isValidAge("abc"));
    }
}
