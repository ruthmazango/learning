package com.javaseventeen.learning.dto;

import com.javaseventeen.learning.model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorPageResponse {
    private List<Doctor> content;
    private int page_number;
    private int total_pages;
    private long total_elements;
}
