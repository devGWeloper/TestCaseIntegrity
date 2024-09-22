package mapper;

import dto.DataDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostgresMapper {

    List<DataDTO> search(DataDTO searchCriteria);

    void save(DataDTO data);

    DataDTO findById(Long id);
}
