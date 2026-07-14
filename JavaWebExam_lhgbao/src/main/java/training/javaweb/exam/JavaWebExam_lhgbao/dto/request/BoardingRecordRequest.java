package training.javaweb.exam.JavaWebExam_lhgbao.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.status.BoardingStatus;

public class BoardingRecordRequest {
    private Integer petId;
    @NotEmpty(message="check-in date can not empty")
    private LocalDateTime checkInDate;
    private String note ;
    
	public BoardingRecordRequest() {
		super();
	}
	
	public Integer getPetId() {
		return petId;
	}
	public void setPetId(Integer petId) {
		this.petId = petId;
	}
	public LocalDateTime getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(LocalDateTime checkInDate) {
		this.checkInDate = checkInDate;
	}
	
    
    
}
