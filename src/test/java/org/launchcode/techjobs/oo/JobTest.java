package org.launchcode.techjobs.oo;

import org.junit.Test;

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

        assertNotNull(job.getName());
        assertEquals("Product tester", job.getName());

        assertNotNull(job.getEmployer());
        assertEquals("ACME", job.getEmployer().getValue());

        assertNotNull(job.getLocation());
        assertEquals("Desert", job.getLocation().getValue());

        assertNotNull(job.getPositionType());
        assertEquals("Quality control", job.getPositionType().getValue());

        assertNotNull(job.getCoreCompetency());
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


}
