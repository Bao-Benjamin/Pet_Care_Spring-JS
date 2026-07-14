package training.javaweb.exam.JavaWebExam_lhgbao.mapper;

import org.apache.ibatis.annotations.Mapper;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.BoardingRecordRequest;

@Mapper
public interface BoardingRecordMapper {
	int createBoardingRecord(BoardingRecordRequest request);
}
