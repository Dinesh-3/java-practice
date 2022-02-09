package jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class User {

    @JsonDeserialize(using = CustomBigDecimalToIntSerializer.class)
//    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = CustomSerializer.class)
    @JsonProperty(value = "Height")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT, pattern = "")
    private BigDecimal height;


    @JsonSerialize(using = DateTimeSerializer.class)
    private LocalDateTime dateOfBirth;

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty(value = "DateOfBirth")
    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }
}
