package com.utils.samples.spring.aop;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.utils.samples.spring.aop.service.ShapeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-aop-config.xml")
public class AopSampleTest {
	
	@Autowired
	ShapeService shapeService;
	
	//we are defining a log appender to be able to check if our logging had really took place.
	@Test
	public void testLogging(){
		final TestAppender appender = new TestAppender();
        final Logger logger = Logger.getRootLogger();
        logger.addAppender(appender);

        shapeService.getTriangle().setName("Trio");
        shapeService.getTriangle().getNewName("Quadro");
        shapeService.getCircle().setName("Circle 1");
        shapeService.getCircle().testThrowException(4);
        
        final List<LoggingEvent> log = appender.getLog();
        final LoggingEvent firstLogEntry = log.get(0);    
              
        assertThat(firstLogEntry.getLevel(), is(Level.INFO));
        assertThat((String) firstLogEntry.getMessage(), is("com.utils.samples.spring.aop.service.ShapeService getter  Called"));
        assertThat(firstLogEntry.getLoggerName(), is("com.utils.samples.spring.aop.aspect.LoggingAspect"));
        
        final LoggingEvent forthLogEntry = log.get(4);
        assertThat(forthLogEntry.getLevel(), is(Level.INFO));
        assertThat((String) forthLogEntry.getMessage(), is("Return value of method is: TrioQuadro"));
        assertThat(forthLogEntry.getLoggerName(), is("com.utils.samples.spring.aop.aspect.LoggingAspect"));
        
        final LoggingEvent sixthLogEntry = log.get(6);
        assertThat(sixthLogEntry.getLevel(), is(Level.INFO));
        assertThat((String) sixthLogEntry.getMessage(), is("Setter Method Called for Circle with param Circle 1"));
        assertThat(sixthLogEntry.getLoggerName(), is("com.utils.samples.spring.aop.aspect.LoggingAspect"));

	}
	
	public static class TestAppender extends AppenderSkeleton {
		
	    private final List<LoggingEvent> log = new ArrayList<LoggingEvent>();

	    
	    public TestAppender() {

	    }
	    
	    public boolean requiresLayout() {
	        return false;
	    }

	    @Override
	    protected void append(final LoggingEvent loggingEvent) {
	        log.add(loggingEvent);
	    }

	    public void close() {
	    }

	    public List<LoggingEvent> getLog() {
	        return new ArrayList<LoggingEvent>(log);
	    }
	}

}
