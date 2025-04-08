package org.example;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class LeaveDetailsTest {
    @Test
    public void testToString() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LeaveDetails ld1 = new LeaveDetails(1, 1000, sdf.parse("2020-10-10"), sdf.parse("2020-10-12"), "Sick",
                LeaveStatus.PENDING, LeaveType.EL);
        String result = "LeaveDetails [leaveId=1, empId=1000, leaveStartDate=Sat Oct 10 00:00:00 IST 2020, leaveEndDate=Mon Oct 12 00:00:00 IST 2020, leaveReason=Sick, "
                + "leaveStatus=PENDING, leaveType=EL]";
        assertEquals(ld1.toString(), result);

    }
    @Test
    public void testGetterSetters() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        LeaveDetails leaveDetails = new LeaveDetails();
        leaveDetails.setLeaveId(1);
        leaveDetails.setEmpId(1000);
        leaveDetails.setLeaveStartDate(sdf.parse("2020-10-10"));
        leaveDetails.setLeaveEndDate(sdf.parse("2020-10-20"));
        leaveDetails.setLeaveReason("Sick");
        leaveDetails.setLeaveType(LeaveType.EL);
        leaveDetails.setLeaveStatus(LeaveStatus.PENDING);

        assertEquals(1, leaveDetails.getLeaveId());
        assertEquals(1000, leaveDetails.getEmpId());
        assertEquals("2020-10-10", sdf.format(leaveDetails.getLeaveStartDate()));
        assertEquals("2020-10-20", sdf.format(leaveDetails.getLeaveEndDate()));  // Fixed this line
        assertEquals("Sick", leaveDetails.getLeaveReason());
        assertEquals(LeaveStatus.PENDING, leaveDetails.getLeaveStatus());
        assertEquals(LeaveType.EL, leaveDetails.getLeaveType());

    }
    @Test
    public  void TestConstructor() throws ParseException {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            LeaveDetails leaveDetails=new LeaveDetails();
            assertNotNull(leaveDetails);
            LeaveDetails ld1=new LeaveDetails(1,1000,sdf.parse("2020-10-10"),sdf.parse("2020-10-12"),
                    "Sick",LeaveStatus.PENDING,LeaveType.EL);

            assertEquals(1,leaveDetails.getLeaveId());
            assertEquals(1000,leaveDetails.getEmpId());
            assertEquals("2020-10-10",sdf.format(leaveDetails.getLeaveStartDate()));
            assertEquals("2020-10-10",sdf.format(leaveDetails.getLeaveEndDate()));
            assertEquals("Sick",leaveDetails.getLeaveReason());
            assertEquals(LeaveStatus.PENDING,leaveDetails.getLeaveStatus());
            assertEquals(LeaveType.EL,leaveDetails.getLeaveType());
        }

}