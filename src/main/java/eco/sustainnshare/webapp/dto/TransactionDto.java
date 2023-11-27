package eco.sustainnshare.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class TransactionDto {
    private Integer transactionID;
    private Integer itemID;
    private ItemDto item;
    private Integer donorID;
    private DonorDto donor;
    private Integer receiverID;
    private Date dateInitiated;
    private Date dateCompleted;
    private String status;
}
