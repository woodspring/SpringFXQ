package woodspring.springfxq;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import woodspring.springfxq.model.FXQuote;
import woodspring.springfxq.utils.FxSpotRate;

public class TestFxSpotRate {
	private final static Logger logger = LoggerFactory.getLogger(TestFxSpotRate.class);
	
	@Test
	public void testFxSpotRate() {
		FxSpotRate fxSpotRate = new FxSpotRate();
		int testNum = 10000;
		List<FXQuote> theList = fxSpotRate.getFXQuoteList(testNum);
		String testStr = "USDCAD";
		long startTime = System.nanoTime();
		theList.stream()
				.filter( item -> !item.getSymbol().equalsIgnoreCase(testStr))
				.collect(Collectors.toList());
		Long endTime = System.nanoTime();
		logger.info("For {} stream time:{} nano second", testNum, endTime-startTime);

		startTime = System.nanoTime();
		theList.parallelStream()
				.filter( item -> !item.getSymbol().equalsIgnoreCase(testStr))
				.collect(Collectors.toList());
		endTime = System.nanoTime();
		logger.info("For {} paralleltream time:{} nano second", testNum, endTime-startTime);

		startTime = System.nanoTime();
		theList.stream()
		.filter( item -> !item.getSymbol().equalsIgnoreCase(testStr))
		.collect(Collectors.toList());
		endTime = System.nanoTime();
		logger.info("For {} stream time:{} nano second", testNum, endTime-startTime);

		
		
	}
	
	
	@Test
	public void testFxSpotRateSort() {
		FxSpotRate fxSpotRate = new FxSpotRate();
		int testNum = 100000;
		List<FXQuote> theList = fxSpotRate.getFXQuoteList(testNum);
		String testStr = "USDCAD";
		long startTime = System.nanoTime();
		List<FXQuote> afterList = theList.stream()
				.sorted( (item1, item2) -> item1.compareTo( item2) )
				.collect(Collectors.toList());
		Long endTime = System.nanoTime();
		logger.info("For {}:{}         stream sort time:{} nano second", afterList.size(), testNum, endTime-startTime);

		startTime = System.nanoTime();
		theList.parallelStream()
				//.filter( item -> !item.getSymbol().equalsIgnoreCase(testStr))
		.sorted( (item1, item2) -> item1.compareTo( item2) )
				.collect(Collectors.toList());
		endTime = System.nanoTime();
		logger.info("For {}:{} parallelstream sort time:{} nano second", afterList.size(),testNum, endTime-startTime);

		startTime = System.nanoTime();
		theList.stream()
		//.filter( item -> !item.getSymbol().equalsIgnoreCase(testStr))
		.sorted( (item1, item2) -> item1.compareTo( item2) )
		.collect(Collectors.toList());
		endTime = System.nanoTime();
		logger.info("For {}:{}         stream sort time:{} nano second", afterList.size(),testNum, endTime-startTime);;

		
		
	}

	
	@Test
	public void testFxSpotRateMap() {
		FxSpotRate fxSpotRate = new FxSpotRate();
		int testNum = 100000;
		List<FXQuote> theList = fxSpotRate.getFXQuoteList(testNum);
		String testStr = "USDCAD";
		long startTime = System.nanoTime();
		List<Float> afterList = theList.stream()
				.map( item -> Float.valueOf(item.getPrice()) * Float.valueOf(item.getSymbol().hashCode()) )
				.collect(Collectors.toList());
		Long endTime = System.nanoTime();
		logger.info("For {}:{}         stream map time:{} nano second", afterList.size(), testNum, endTime-startTime);

		startTime = System.nanoTime();
		theList.parallelStream()
				//.filter( item -> !item.getSymbol().equalsIgnoreCase(testStr))
			.map( item -> Float.valueOf(item.getPrice()) * Float.valueOf(item.getSymbol().hashCode()) )
				.collect(Collectors.toList());
		endTime = System.nanoTime();
		logger.info("For {}:{} parallelstream map time:{} nano second", afterList.size(),testNum, endTime-startTime);

		startTime = System.nanoTime();
		theList.stream()
			.map( item -> Float.valueOf(item.getPrice()) * Float.valueOf(item.getSymbol().hashCode()) )
			.collect(Collectors.toList());
		endTime = System.nanoTime();
		logger.info("For {}:{}         stream amp time:{} nano second", afterList.size(),testNum, endTime-startTime);;

		
		
	}
	
	@Test
	public void testFxSpotRateFilterMap() {
		FxSpotRate fxSpotRate = new FxSpotRate();
		int testNum = 80000;
		List<FXQuote> theList = fxSpotRate.getFXQuoteList(testNum);
		String testStr = "USDCAD";
		long startTime = System.nanoTime();
		List<Float> afterList = theList.stream()
				.filter( item -> !item.getSymbol().equalsIgnoreCase("USDCAD"))
				.map( item -> Float.valueOf(item.getPrice()) * Float.valueOf(item.getSymbol().hashCode()) )
				.collect(Collectors.toList());
		Long endTime = System.nanoTime();
		logger.info("For {}:{}         stream filter map time:{} nano second", afterList.size(), testNum, endTime-startTime);

		startTime = System.nanoTime();
		theList.parallelStream()
			.filter( item -> !item.getSymbol().equalsIgnoreCase("USDCAD"))
			.map( item -> Float.valueOf(item.getPrice()) * Float.valueOf(item.getSymbol().hashCode()) )
				.collect(Collectors.toList());
		endTime = System.nanoTime();
		logger.info("For {}:{} parallelstream filter map time:{} nano second", afterList.size(),testNum, endTime-startTime);

		startTime = System.nanoTime();
		theList.stream()
			.filter( item -> !item.getSymbol().equalsIgnoreCase("USDCAD"))
			.map( item -> Float.valueOf(item.getPrice()) * Float.valueOf(item.getSymbol().hashCode()) )
			.collect(Collectors.toList());
		endTime = System.nanoTime();
		logger.info("For {}:{}         stream filter map time:{} nano second", afterList.size(),testNum, endTime-startTime);;

		
		
	}
	
	@Test
	public void testFxSpotRateReflect() {
		FxSpotRate fxSpotRate = new FxSpotRate();
		
		try {
			Field tenorField = fxSpotRate.getClass().getDeclaredField("tenor");
			tenorField.setAccessible(true);
			logger.info(" teno-1-:{}", tenorField.get( fxSpotRate));
			tenorField.setInt( fxSpotRate,  2);
			logger.info(" teno-2-:{}", tenorField.get( fxSpotRate));
			
			tenorField = FxSpotRate.class.getDeclaredField("tenor");
			tenorField.setAccessible(true);
			logger.info(" teno-3-:{}", tenorField.get( fxSpotRate));
			tenorField.setInt( fxSpotRate,  4);
			logger.info(" teno-4-:{}", tenorField.get( fxSpotRate));
			
			//Method setSymbol = 
			Arrays.asList( fxSpotRate.getClass().getDeclaredMethods()).stream().forEach(item -> logger.info(" method:{}", item.toString()));
			Method getList = FxSpotRate.class.getDeclaredMethod("getFXQuoteList",  int.class, String[].class);
			int testNum = 1000000;
			long startTime = System.nanoTime();
			List<FXQuote> theList = (List<FXQuote>) getList.invoke( fxSpotRate, 1000000, "EURUSD");
			long endTime = System.nanoTime();
			logger.info("For Reflection {}:{} reflect :{} nano second", theList.size(),testNum, endTime-startTime);

			//Method setPxStrMethod = fx
			
		} catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
		

	}
}
