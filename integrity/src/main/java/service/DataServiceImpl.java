package service;

import dto.DataDTO;
import mapper.OracleMapper;
import mapper.PostgresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DataServiceImpl implements DataService {

    private final OracleMapper oracleMapper;
    private final PostgresMapper postgresMapper;

    @Autowired
    public DataServiceImpl(OracleMapper oracleMapper, PostgresMapper postgresMapper) {
        this.oracleMapper = oracleMapper;
        this.postgresMapper = postgresMapper;
    }

    @Override
    public List<DataDTO> searchData(DataDTO searchCriteria) {
        List<DataDTO> oracleResults = oracleMapper.search(searchCriteria);
        List<DataDTO> postgresResults = postgresMapper.search(searchCriteria);

        return Stream.concat(oracleResults.stream(), postgresResults.stream())
                .collect(Collectors.toList());
    }

    @Override
    public void createData(DataDTO data) {
        postgresMapper.save(data);
    }

    @Override
    public DataDTO getDataById(Long id) {
        // 여기서는 간단히 Oracle에서만 조회합니다. 실제로는 두 DB를 모두 list로 합쳐서 return 해주기
        return oracleMapper.findById(id);
    }
}
