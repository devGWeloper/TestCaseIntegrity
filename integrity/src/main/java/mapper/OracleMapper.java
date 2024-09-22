package mapper;

import dto.DataDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OracleMapper {

    List<DataDTO> search(DataDTO searchCriteria);

    DataDTO findById(Long id);
}
