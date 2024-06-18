import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyResource {

	@RequestMapping(value = "/rest/api")
	public String api() {
		
		
        return "task complete";

	}
}
