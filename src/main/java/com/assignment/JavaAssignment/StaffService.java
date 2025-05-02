package com.assignment.JavaAssignment;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StaffService {
    private final Map<Long, Staff> staffMap = new HashMap<>();
    private long currentId = 1;

    public List<Staff> getAllStaffs() {
        return new ArrayList<>(staffMap.values());
    }

    public Staff getStaffById(Long id) {
        return staffMap.get(id);
    }

    public Staff createStaff(Staff staff) {
        staff.setId(currentId++);
        staffMap.put(staff.getId(), staff);
        return staff;
    }

    public Staff updateStaff(Long id, Staff updatedStaff) {
        if (staffMap.containsKey(id)) {
            updatedStaff.setId(id);
            staffMap.put(id, updatedStaff);
            return updatedStaff;
        }
        return null;
    }

    public boolean deleteStaff(Long id) {
        return staffMap.remove(id) != null;
    }
}
