package com.employee.managment.Employee.Management.conf;

import java.util.*;
import java.util.stream.Collectors;

class Patient {
    int roomNo;
    boolean isReadmitted;
    String patientName;

    Patient(int roomNo, boolean isReadmitted, String patientName) {
        this.roomNo = roomNo;
        this.isReadmitted = isReadmitted;
        this.patientName = patientName;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public boolean isReadmitted() {
        return isReadmitted;
    }

    @Override
    public String toString() {
        return "Room " + roomNo + ": " + patientName + (isReadmitted ? " (Readmitted)" : " (Not Readmitted)");
    }
}

public class PatientDashboard {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
                new Patient(300, true, "Patient A"),
                new Patient(310, true, "Patient B"),
                new Patient(301, false, "Patient C"),
                new Patient(303, true, "Patient D"),
                new Patient(302, false, "Patient E")
        );

        // Example: Sort by readmission first, then room number ascending
        List<Patient> sortedPatients = patients.stream()
                .sorted(Comparator.comparing(Patient::isReadmitted)
                        .reversed() // To have readmitted patients first
                        .thenComparing(Patient::getRoomNo)) // Then sort by room number ascending
                .collect(Collectors.toList());

        System.out.println("Sorted by Readmission (Readmitted first) and Room No Ascending:");
        sortedPatients.forEach(System.out::println);

        // Example of toggling: If clicked again, first by room number, then readmission status
        List<Patient> sortedByRoom = patients.stream()
                .sorted(Comparator.comparing(Patient::getRoomNo)
                        .thenComparing(Patient::isReadmitted)) // Sort by room number ascending, then readmission
                .collect(Collectors.toList());

        System.out.println("\nToggled Sorting (Room No Ascending, then Readmission Status):");
        sortedByRoom.forEach(System.out::println);
    }
}

