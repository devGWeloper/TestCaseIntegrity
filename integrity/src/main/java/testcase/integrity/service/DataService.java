package testcase.integrity.service;

import testcase.integrity.dto.DataDTO;

import java.util.List;

public interface DataService {
    List<DataDTO> searchData(DataDTO searchCriteria);

    void createData(DataDTO data);

    DataDTO getDataById(Long id);
}
