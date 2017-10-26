package systemman;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.busi.quarz.OrderedSchedulerJobService;

public class QuarzTest extends TestBase {
	@Autowired
	private OrderedSchedulerJobService orderedSchedulerJobService;
	@Test
	public void dsTest(){
		orderedSchedulerJobService.excute();
	}
}
