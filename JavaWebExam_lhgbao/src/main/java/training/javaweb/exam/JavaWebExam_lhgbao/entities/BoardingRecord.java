package training.javaweb.exam.JavaWebExam_lhgbao.entities;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.status.BoardingStatus;

public class BoardingRecord {
	private Integer id;
    private Integer petId;
    private LocalDateTime checkInDate;
    private LocalDateTime expectedReturnDate;
    private LocalDateTime actualReturnDate;
    private Double pricePerDay;
    private Double baseFee;
    private Double lateFee;
    private Double totalFee;
	private BoardingStatus status;
	public BoardingRecord() {
		super();
	}
	
	public BoardingRecord(Integer id, Integer petId, LocalDateTime checkInDate, LocalDateTime expectedReturnDate,
			LocalDateTime actualReturnDate, Double pricePerDay, Double baseFee, Double lateFee, Double totalFee,
			BoardingStatus status) {
		super();
		this.id = id;
		this.petId = petId;
		this.checkInDate = checkInDate;
		this.expectedReturnDate = expectedReturnDate;
		this.actualReturnDate = actualReturnDate;
		this.pricePerDay = pricePerDay;
		this.baseFee = baseFee;
		this.lateFee = lateFee;
		this.totalFee = totalFee;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public LocalDateTime getExpectedReturnDate() {
		return expectedReturnDate;
	}
	public void setExpectedReturnDate(LocalDateTime expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}
	public LocalDateTime getActualReturnDate() {
		return actualReturnDate;
	}
	public void setActualReturnDate(LocalDateTime actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}
	public Double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public Double getBaseFee() {
		return baseFee;
	}
	public void setBaseFee(Double baseFee) {
		this.baseFee = baseFee;
	}
	public Double getLateFee() {
		return lateFee;
	}
	public void setLateFee(Double lateFee) {
		this.lateFee = lateFee;
	}
	public Double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	public BoardingStatus getStatus() {
		return status;
	}
	public void setStatus(BoardingStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BoardingRecord [id=" + id + ", petId=" + petId + ", checkInDate=" + checkInDate
				+ ", expectedReturnDate=" + expectedReturnDate + ", actualReturnDate=" + actualReturnDate
				+ ", pricePerDay=" + pricePerDay + ", baseFee=" + baseFee + ", lateFee=" + lateFee + ", totalFee="
				+ totalFee + ", status=" + status + "]";
	}
    
}
