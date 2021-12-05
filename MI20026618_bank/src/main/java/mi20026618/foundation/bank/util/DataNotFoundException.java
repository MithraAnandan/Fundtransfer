package mi20026618.foundation.bank.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataNotFoundException extends RuntimeException{
	String message;

}
