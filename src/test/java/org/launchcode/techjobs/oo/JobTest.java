package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job aJob = new Job();
        Job someJob = new Job();
        assertNotEquals(aJob.getId(), someJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertEquals("Product tester", job.getName());

        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());

        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());

        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());

        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job aJob = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job someJob = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertNotEquals(aJob, someJob);

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String firstChar = String.valueOf(job.toString().charAt(0));
        String lastChar = String.valueOf(job.toString().charAt(job.toString().length()-1));
        assertEquals(firstChar, lineSeparator() );
        assertEquals(lastChar, lineSeparator() );
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String output = String.format(
                lineSeparator() +
                        "ID: %d" + lineSeparator() +
                        "Name: %s" + lineSeparator() +
                        "Employer: %s" + lineSeparator() +
                        "Location: %s" + lineSeparator() +
                        "Position Type: %s" + lineSeparator() +
                        "Core Competency: %s" +
                        lineSeparator(), job.getId(), job.getName(), job.getEmployer(), job.getLocation(), job.getPositionType(), job.getCoreCompetency());
        assertEquals(output, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location(""),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String output = String.format(
                lineSeparator()+
                        "ID: %d" + lineSeparator() +
                        "Name: %s" + lineSeparator() +
                        "Employer: %s" + lineSeparator() +
                        "Location: Data not available" + lineSeparator() +
                        "Position Type: %s" + lineSeparator() +
                        "Core Competency: %s"+ lineSeparator() ,job.getId(), job.getName(), job.getEmployer(), job.getPositionType(), job.getCoreCompetency());
        assertEquals(output, job.toString());

    }
}
